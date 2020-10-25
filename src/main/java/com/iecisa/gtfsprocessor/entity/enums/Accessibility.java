package com.iecisa.gtfsprocessor.entity.enums;

public enum Accessibility
{
    NO_INFO(0),
    ACCESSIBLE(1),
    NOT_ACCESSIBLE(2);

    public final int id;

    Accessibility(int id) { this.id = id; }

    public static Accessibility value(int id)
    {
        for (Accessibility t : Accessibility.values())
            if (t.id == id) return t;
        return null;
    }
}
