package com.iecisa.gtfsprocessor.entity.enums;

public enum Direction
{
    NATURAL(0),
    COUNTER(1);

    public final int id;

    Direction(int id) { this.id = id; }

    public static Direction value(int id)
    {
        for (Direction t : Direction.values())
            if (t.id == id) return t;
        return null;
    }
}
