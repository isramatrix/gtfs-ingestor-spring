package com.iecisa.gtfsprocessor.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class GtfsEntity
{
    public GtfsEntity() { }

    public GtfsEntity(Map<String, String> tuple)
    {
        for (Field field : getClass().getDeclaredFields())
        {
            try {
                Column annotation = field.getAnnotation(Column.class);
                if (tuple.containsKey(annotation.name()))
                {
                    field.setAccessible(true);

                    String value = tuple.get(annotation.name());
                    Class<?> type = field.getType();

                    if (type.equals(Integer.class))
                        field.set(this, new Integer(value));
                    else if (type.equals(Float.class))
                        field.set(this, new Float(value));
                    else if (type.equals(Double.class))
                        field.set(this, new Double(value));
                    else field.set(this, value);

                    field.setAccessible(false);
                }
            } catch (Exception ignored) { }
        }
    }
}
