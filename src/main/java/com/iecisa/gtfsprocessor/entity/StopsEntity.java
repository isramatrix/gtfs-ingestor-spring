package com.iecisa.gtfsprocessor.entity;

import com.iecisa.gtfsprocessor.entity.enums.Accessibility;

import javax.persistence.*;
import java.util.Map;
import java.util.TimeZone;

@Entity
@Table(name = "stops")
public class StopsEntity extends GtfsEntity
{
    @Id
    @GeneratedValue
    long uuid;

    public enum Type {
        STOP(0), STATION(1), ENTRANCE(2), GENERIC_NODE(3), BOARDING_AREA(4);
        public final int id;
        Type(int id) { this.id = id; }
        public static Type value(int id) {
            for (Type t : Type.values())
                if (t.id == id) return t;
            return null;
        }
    }

    @Column(name = "stop_id")
    private String id;

    @Column(name = "stop_code")
    private String code;

    @Column(name = "stop_name")
    private String name;

    @Column(name = "stop_desc")
    private String description;

    @Column(name = "stop_lat")
    private Double latitude;

    @Column(name = "stop_lon")
    private Double longitude;

    @Column(name = "zone_id")
    private String zoneId;

    @Column(name = "stop_url")
    private String url;

    @Column(name = "location_type")
    private Type locationType;

    @Column(name = "parent_station")
    private String parentStation;

    @Column(name = "stop_timezone")
    private TimeZone timezone;

    @Column(name = "wheelchair_boarding")
    private Accessibility wheelchairBoarding;

    @Column(name = "level_id")
    private String levelId;

    @Column(name = "platform_code")
    private String platformCode;

    public StopsEntity() { }

    public StopsEntity(Map<String, String> tuple) {
        super(tuple);
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getZoneId() {
        return zoneId;
    }

    public String getUrl() {
        return url;
    }

    public Type getLocationType() {
        return locationType;
    }

    public String getParentStation() {
        return parentStation;
    }

    public TimeZone getTimezone() {
        return timezone;
    }

    public Accessibility getWheelchairBoarding() {
        return wheelchairBoarding;
    }

    public String getLevelId() {
        return levelId;
    }

    public String getPlatformCode() {
        return platformCode;
    }
}
