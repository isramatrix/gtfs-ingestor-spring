package com.iecisa.gtfsprocessor.logic.sources;

import com.iecisa.gtfsprocessor.logic.GtfsField;
import com.iecisa.gtfsprocessor.utils.FtpClient;
import com.iecisa.gtfsprocessor.utils.ZipExtractor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.nio.file.Files.*;
import static java.nio.file.Paths.*;

public class FtpSource implements GtfsSource
{
    private static final String DOWNLOAD_PATH = "./temp/gtfs/download/";

    private static final String UNZIPPING_PATH = "./temp/gtfs/unzip/";

    private static final String ZIP_NAME = "gtfs.zip";

    private final ZipExtractor extractor = new ZipExtractor();

    private final FtpClient client;

    private String fileName;

    public FtpSource(String server, String username, String password)
    {
        client = new FtpClient(server, username, password);
    }

    /*
     * Especifica el nombre del fichero comprimido GTFS que se encuenta en el
     * servidor GTFS para ser descargado, en caso de que tenga un nombre específico.
     * Por defecto, el nombre que busca en el servidor es 'gtfs.zip'.
     *
     * @param fileName El nombre del fichero GTFS.
     */
    public FtpSource setGtfsFileName(String fileName)
    {
        this.fileName = fileName;
        return this;
    }

    @Override
    public Map<GtfsField, String> getCsvString() throws IOException
    {
        // Se descarga el comprimido zip con los ficheros GTFS en la carpeta especificada.
        client.downloadFile(
                fileName == null ? ZIP_NAME : fileName,
                DOWNLOAD_PATH + ZIP_NAME
        );

        // Cierra la conexión FTP.
        client.close();

        // Extrae los ficheros GTFS en la carpeta especificada.
        List<File> gtfsFiles = extractor.extract(DOWNLOAD_PATH + ZIP_NAME, UNZIPPING_PATH);

        // Carga en memoria el contenido de los ficheros GTFS.
        Map<GtfsField, String> result = new HashMap<>();
        for (File gtfsFile : gtfsFiles)
        {
            // Obtiene el campo GTFS al que se refiere el fichero GTFS.
            GtfsField field = GtfsField.ofFile(gtfsFile.getName());

            // Extrae el contenido GTFS en caso de ser un fichero conocido.
            if (field != null) {
                String csv = new String(readAllBytes(get(gtfsFile.toURI())), StandardCharsets.UTF_8);
                result.put(field, normalize(csv));

            } else logUnknownField(gtfsFile.getName());
        }

        return result;
    }

    private String normalize(String text)
    {
        if (text.startsWith("\uFEFF"))
            text = text.substring(1);
        return text;
    }

    private void logUnknownField(String gtfsFile)
    {

    }
}
