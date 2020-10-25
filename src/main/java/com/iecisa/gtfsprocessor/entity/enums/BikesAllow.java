package com.iecisa.gtfsprocessor.entity.enums;

public enum BikesAllow
{
    NO_INFO(0),
    ALLOWED(1),
    NOT_ALLOWED(2);

    public final int id;

    BikesAllow(int id) { this.id = id; }

    public static BikesAllow value(int id)
    {
        for (BikesAllow t : BikesAllow.values())
            if (t.id == id) return t;
        return null;
    }
}
