package com.iecisa.gtfsprocessor.logic.sources;

import com.iecisa.gtfsprocessor.logic.GtfsField;

import java.io.IOException;
import java.util.Map;

public interface GtfsSource
{
    Map<GtfsField, String> getCsvString() throws IOException;
}
