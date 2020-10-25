package com.iecisa.gtfsprocessor.utils;

import com.iecisa.gtfsprocessor.model.DatabaseEnvironment;

import java.io.File;

public class K
{
    public static class Paths
    {
        public static final String RESOURCES = "./src/main/resources";

        public static final String QUERIES =
            RESOURCES + File.separator +
            "queries";

        public static final String BUILDERS =
            QUERIES + File.separator +
            "builders";

        public static final String BUILDERS(DatabaseEnvironment environment) {
            return BUILDERS + File.separator +
                environment.getAbbreviation();
        }
    }
}
