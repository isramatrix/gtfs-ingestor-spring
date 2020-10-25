package com.iecisa.gtfsprocessor.logic;

import com.iecisa.gtfsprocessor.entity.GtfsEntity;
import com.iecisa.gtfsprocessor.logic.observer.TransactionObserver;
import com.iecisa.gtfsprocessor.logic.sources.GtfsSource;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.Transaction;
import java.io.IOException;
import java.util.*;

public class GtfsInsertion
{
    private Gtfs gtfs;

    private GtfsSource source;

    private Date version;

    private List<GtfsField> exclusions = new ArrayList<>();

    /**
     * Instantiate a new GTFS insertion, in order to populate an already-created
     * schema and tables of a dababase.
     *
     * @param gtfs The autowired GTFS service instance.
     * @param source The GTFS files source where retrieve the data.
     */
    public GtfsInsertion(Gtfs gtfs, GtfsSource source)
    {
        this.source = source;
        this.gtfs = gtfs;
    }

    /**
     * Excludes a GTFS file in the insertion of GTFS file, in case
     * the provider does not provide the specified kind of file.
     *
     * @param field The GTFS filed to exclude.
     *
     * @return this instance.
     */
    public GtfsInsertion exclude(GtfsField field)
    {
        this.exclusions.add(field);
        return this;
    }

    /**
     * Sets the version of the GTFS insertion. In case the created schema
     * does not manage versions, the insertion will throw a NotManagedVersionException.
     *
     * @param version The version of the insertion
     *
     * @return this instance.
     */
    public GtfsInsertion setVersion(Date version)
    {
        this.version = version;
        return this;
    }

    /**
     * Performs a transaction in the database where GTFS schema is populated
     * with the specified GTFS source.
     *
     * @throws IOException In case the GTFS source could not read the files.
     */
    @Transactional
    public void insert() throws IOException
    {
        insert(null);
    }

    /**
     * Performs a transaction in the database where GTFS schema is populated
     * with the specified GTFS source.
     *
     * @param observer An observer of the state of the transaction.
     *
     * @throws IOException In case the GTFS source could not read the files.
     */
    @Transactional
    public void insert(TransactionObserver observer) throws IOException
    {
        // Obtiene todos los archivos CSV del GTFS.
        Map<GtfsField, String> csvMap = source.getCsvString();

        // Lee los ficheros GTFS y los carga en memoria.
        Map<GtfsField, List<? extends GtfsEntity>> entities = new HashMap<>();
        for (GtfsField field : csvMap.keySet())

            // Sólo en caso de que no se haya excluído explicitamente la carga.
            if (!exclusions.contains(field)) {
                String csv = csvMap.get(field);
                entities.put(field, field.read(csv));
            }

        // Notifica al observador que se han descargado y procesado los ficheros GTFS.
        if (observer != null) observer.onDownloaded();

        // Actualiza los datos GTFS de la base de datos.
        performGtfsTransaction(entities, observer);
    }

    @Transactional
    void performGtfsTransaction(Map<GtfsField, List<? extends GtfsEntity>> entities, TransactionObserver observer)
    {
        int transactionCount = 0;

        // Añade los registros nuevos del GTFS a la base de datos.
        try {
            for (GtfsField field : entities.keySet())
            {
                // Notifica de la inserción en base de datos al observador de progreso
                if (observer != null) observer.onFieldStart(field, entities.size());

                // Realiza efectivamente la transacción en base de datos.
                gtfs.get(field).saveAll(entities.get(field));

                // Notifica de la inserción en base de datos al observador de progreso
                if (observer != null) {
                    observer.onFieldCommit(field, entities.size());
                    observer.onProgress(++transactionCount / (float) entities.size());
                }
            }

        // En caso de que haya habido error en la inserción, hace rollback de los cambios.
        } catch (Exception e) {

            if (observer != null) observer.onError(e);
            for (GtfsField field : entities.keySet())
                gtfs.get(field).deleteAll(entities.get(field));
        }
    }
}
