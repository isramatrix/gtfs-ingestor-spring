package com.iecisa.gtfsprocessor.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class GtfsDeletion
{
    private final Gtfs gtfs;

    private Date version;

    private String schema;

    private List<GtfsField> exclusions = new ArrayList<>();

    public GtfsDeletion(Gtfs gtfs) {
        this.gtfs = gtfs;
    }

    public GtfsDeletion setVersion(Date version)
    {
        this.version = version;
        return this;
    }

    public GtfsDeletion setSchema(String schema)
    {
        this.schema = schema;
        return this;
    }

    public GtfsDeletion exclude(GtfsField field)
    {
        this.exclusions.add(field);
        return this;
    }

    public void delete()
    {
        for (GtfsField field : GtfsField.values())
            // Sólo en caso de que no se haya excluído explicitamente el borrado.
            if (!exclusions.contains(field)) gtfs.get(field).deleteAll();
    }
}
