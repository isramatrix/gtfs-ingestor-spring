package com.iecisa.gtfsprocessor.logic;

import com.iecisa.gtfsprocessor.logic.GtfsField;
import com.iecisa.gtfsprocessor.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public final class Gtfs
{
    @Value("${gtfs.schema:#{null}}")
    String schema;

    @PersistenceContext
    EntityManager manager;

    @Autowired @Qualifier("default")
    private AgencyRepository agency;

    @Autowired @Qualifier("default")
    private AttributionsRepository attributions;

    @Autowired @Qualifier("default")
    private CalendarDatesRepository calendarDates;

    @Autowired @Qualifier("default")
    private CalendarRepository calendar;

    @Autowired @Qualifier("default")
    private FareAttributesRepository fareAttributes;

    @Autowired @Qualifier("default")
    private FareRulesRepository fareRules;

    @Autowired @Qualifier("default")
    private FeedInfoRepository feedInfo;

    @Autowired @Qualifier("default")
    private FrequenciesRepository frequencies;

    @Autowired @Qualifier("default")
    private LevelsRepository levels;

    @Autowired @Qualifier("default")
    private PathwaysRepository pathways;

    @Autowired @Qualifier("default")
    private RoutesRepository routes;

    @Autowired @Qualifier("default")
    private ShapesRepository shapes;

    @Autowired @Qualifier("default")
    private StopsRepository stops;

    @Autowired @Qualifier("default")
    private StopTimesRepository stopTimes;

    @Autowired @Qualifier("default")
    private TransfersRepository transfers;

    @Autowired @Qualifier("default")
    private TranslationsRepository translations;

    @Autowired @Qualifier("default")
    private TripsRepository trips;

    public AgencyRepository getAgency() {
        return agency;
    }

    public AttributionsRepository getAttributions() {
        return attributions;
    }

    public CalendarDatesRepository getCalendarDates() {
        return calendarDates;
    }

    public CalendarRepository getCalendar() {
        return calendar;
    }

    public FareAttributesRepository getFareAttributes() {
        return fareAttributes;
    }

    public FareRulesRepository getFareRules() {
        return fareRules;
    }

    public FeedInfoRepository getFeedInfo() {
        return feedInfo;
    }

    public FrequenciesRepository getFrequencies() {
        return frequencies;
    }

    public LevelsRepository getLevels() {
        return levels;
    }

    public PathwaysRepository getPathways() {
        return pathways;
    }

    public RoutesRepository getRoutes() {
        return routes;
    }

    public StopsRepository getStops() {
        return stops;
    }

    public StopTimesRepository getStopTimes() {
        return stopTimes;
    }

    public TransfersRepository getTransfers() {
        return transfers;
    }

    public TranslationsRepository getTranslations() {
        return translations;
    }

    public TripsRepository getTrips() {
        return trips;
    }

    public ShapesRepository getShapes() {
        return shapes;
    }

    public GtfsRepository get(GtfsField field)
    {
        switch (field)
        {
            case AGENCY: return agency;
            case STOPS: return stops;
            case ROUTES: return routes;
            case TRIPS: return trips;
            case STOP_TIMES: return stopTimes;
            case CALENDAR: return calendar;
            case CALENDAR_DATES: return calendarDates;
            case FARE_ATTRIBUTES: return fareAttributes;
            case FARE_RULES: return fareRules;
            case SHAPES: return shapes;
            case FREQUENCIES: return frequencies;
            case TRANSFERS: return transfers;
            case PATHWAYS: return pathways;
            case LEVELS: return levels;
            case FEED_INFO: return feedInfo;
            case TRANSLATIONS: return translations;
            case ATTRIBUTIONS: return attributions;
            default: return null;
        }
    }
}
