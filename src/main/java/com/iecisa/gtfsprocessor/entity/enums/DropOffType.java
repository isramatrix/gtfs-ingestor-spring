package com.iecisa.gtfsprocessor.entity.enums;

public enum DropOffType
{
    REGULAR(0),
    NOT_AVAILABLE(1),
    CONCERTED(2),
    ORGANIZED(3);

    public final int id;

    DropOffType(int id) { this.id = id; }

    public static DropOffType value(int id)
    {
        for (DropOffType d : DropOffType.values())
            if (d.id == id) return d;
        return null;
    }
}
