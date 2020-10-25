package com.iecisa.gtfsprocessor.logic.interpreters;

import com.iecisa.gtfsprocessor.entity.GtfsEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GtfsInterpreter
{
    private final Class<? extends GtfsEntity> type;

    public <T extends GtfsEntity> GtfsInterpreter(Class<T> type)
    {
        this.type = type;
    }

    public final List<? extends GtfsEntity> read(String csv)
    {
        List<? extends GtfsEntity> entities = new ArrayList<>();

        String[] rows = csv.split("\r\n");
        String[] headers = rows[0].split(",");

        for (int i = 1; i < rows.length; i++)
        {
            Map<String, String> tuple = toTuple(headers, rows[i].split(","));
            entities.add(instantiate(tuple));
        }

        return entities;
    }

    private Map<String, String> toTuple(String[] headers, String[] fields)
    {
        Map<String, String> tuples = new HashMap<>();

        for (int i = 0; i < headers.length; i++)
            tuples.put(headers[i], fields[i]);

        return tuples;
    }

    private <T extends GtfsEntity> T instantiate(Map<String, String> tuple)
    {
        try {
            return (T) type.getDeclaredConstructor(Map.class).newInstance(tuple);

        } catch (Exception ignored) { return null; }
    }
}
