package com.iecisa.gtfsprocessor.entity.enums;

public enum PickupType
{
    REGULAR(0),
    NOT_AVAILABLE(1),
    CONCERTED(2),
    ORGANIZED(3);

    public final int id;

    PickupType(int id) { this.id = id; }

    public static PickupType value(int id)
    {
        for (PickupType p : PickupType.values())
            if (p.id == id) return p;
        return null;
    }
}
