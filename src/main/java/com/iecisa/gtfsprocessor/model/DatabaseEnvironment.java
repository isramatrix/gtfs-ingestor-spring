package com.iecisa.gtfsprocessor.model;

public abstract class DatabaseEnvironment
{
    public String getAbbreviation() {
        return "psql";
    }

    public String getExtension() {
        return ".sql";
    }
}
