package com.iecisa.gtfsprocessor.logic;

import com.iecisa.gtfsprocessor.entity.*;
import com.iecisa.gtfsprocessor.logic.interpreters.*;

import java.util.List;

public enum GtfsField
{
    AGENCY("agency", AgencyEntity.class),

    STOPS("stops", StopsEntity.class),

    ROUTES("routes", RoutesEntity.class),

    TRIPS("trips", TripsEntity.class),

    STOP_TIMES("stop_times", StopTimesEntity.class),

    CALENDAR("calendar", CalendarEntity.class),

    CALENDAR_DATES("calendar_dates", CalendarDatesEntity.class),

    FARE_ATTRIBUTES("fare_attributes", FareAttributesEntity.class),

    FARE_RULES("fare_rules", FareRulesEntity.class),

    SHAPES("shapes", ShapesEntity.class),

    FREQUENCIES("frequencies", FrequenciesEntity.class),

    TRANSFERS("transfers", TransfersEntity.class),

    PATHWAYS("pathways", PathwaysEntity.class),

    LEVELS("levels", LevelsEntity.class),

    FEED_INFO("feed_info", FeedInfoEntity.class),

    TRANSLATIONS("translations", TranslationsEntity.class),

    ATTRIBUTIONS("attributions", AttributionsEntity.class);

    private final Class<? extends GtfsEntity> entityClass;

    private String name;

    private GtfsInterpreter interpreter;

    GtfsField(String name, Class<? extends GtfsEntity> entityClass)
    {
        this.name = name;
        this.interpreter = new GtfsInterpreter(entityClass);
        this.entityClass = entityClass;
    }

    public String getName() { return name; }

    public List<? extends GtfsEntity> read(String csv)
    {
        return interpreter.read(csv);
    }

    public Class<? extends GtfsEntity> getEntityClass() {
        return entityClass;
    }
    
    public static GtfsField ofFile(String fileName)
    {
        String onlyName = fileName.replace(".txt", "");

        for (GtfsField value : GtfsField.values())
            if (value.name.equals(onlyName)) return value;

        return null;
    }
}
