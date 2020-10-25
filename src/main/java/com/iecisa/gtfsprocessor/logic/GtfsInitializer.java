package com.iecisa.gtfsprocessor.logic;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.*;

import static org.hibernate.tool.hbm2ddl.SchemaExport.Action.CREATE;

public final class GtfsInitializer
{
    private List<GtfsField> exclusions = new ArrayList<>();

    private boolean versioned;

    private String schema;

    private final Gtfs gtfs;

    private final String classpathResource;

    /**
     * Instantiate a new GTFS database initializer, in order to create the
     * schema and tables neded to store the GTFS files. Database must be created.
     *
     * @param gtfs The autowired GTFS service instance.
     * @param classpathResource The classpath to the properties file.
     */
    public GtfsInitializer(Gtfs gtfs, String classpathResource)
    {
        this.gtfs = gtfs;
        this.classpathResource = classpathResource;
    }

    /**
     * Excludes a GTFS file in the creation of database and tables, in case
     * the provider does not provide the specified kind of file.
     *
     * @param field The GTFS filed to exclude.
     *
     * @return this instance.
     */
    public GtfsInitializer exclude(GtfsField field)
    {
        this.exclusions.add(field);
        return this;
    }

    /**
     * Allow manage timestamp versions in the GTFS stores. By default, this
     * value remains false. If checked, a new column in all entities named
     * 'version' will be created
     *
     * @return this instance.
     */
    public GtfsInitializer allowVersion()
    {
        this.versioned = true;
        return this;
    }

    /**
     * Performs a transaction in the database where the schema and
     * the main tables needed to save GTFS files are created.
     *
     * Inicia una transacción en la que se crea el esquema de base de
     * datos y las tablas necesarias para almacenar los ficheros GTFS.
     *
     * @throws IOException in case the provided properties file could not be read.
     */
    public void build() throws IOException
    {
        StandardServiceRegistry service = createService();
        EnumSet<TargetType> target = EnumSet.of(TargetType.DATABASE);

        for (GtfsField field : GtfsField.values())
        {
            if (exclusions.contains(field)) continue;

            MetadataSources sources = new MetadataSources(service);
            sources.addAnnotatedClass(field.getEntityClass());
            Metadata metadata = sources.buildMetadata();

            SchemaExport schemaExport = new SchemaExport();
            schemaExport.setFormat(true);
            schemaExport.execute(target, CREATE, metadata);
        }
    }

    private StandardServiceRegistry createService() throws IOException
    {
        Resource resource = new ClassPathResource(classpathResource);
        Properties props = PropertiesLoaderUtils.loadProperties(resource);

        Map<String, String> settings = new HashMap<>();
        settings.put("connection.driver_class", props.getProperty("spring.datasource.driver-class-name"));
        settings.put("hibernate.dialect", props.getProperty("spring.jpa.properties.hibernate.dialect"));
        settings.put("hibernate.connection.url", props.getProperty("spring.datasource.url"));
        settings.put("hibernate.connection.username", props.getProperty("spring.datasource.username"));
        settings.put("hibernate.connection.password", props.getProperty("spring.datasource.password"));
        if (gtfs.schema != null) settings.put(Environment.DEFAULT_SCHEMA, gtfs.schema);

        return new StandardServiceRegistryBuilder()
                .applySettings(settings).build();
    }
}
