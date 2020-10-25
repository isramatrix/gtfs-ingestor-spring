package com.iecisa.gtfsprocessor.entity;

import com.iecisa.gtfsprocessor.entity.enums.DropOffType;
import com.iecisa.gtfsprocessor.entity.enums.PickupType;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "routes")
public class RoutesEntity extends GtfsEntity
{
    @Id
    @GeneratedValue
    long uuid;

    public enum Type {
        TRAM(0), SUBWAY(1), RAIL(2), BUS(3), FERRY(4), CABLE_TRAM(5), AERIAL_LIFT(6), FUNICULAR(7), TROLLEYBUS(11), MONORAIL(12);
        public final int id;
        Type(int id) { this.id = id; }
        public static Type value(int id) {
            for (Type t : Type.values())
                if (t.id == id) return t;
            return null;
        }
    }

    @Column(name = "route_id")
    private String id;

    @Column(name = "agency_id")
    private String agencyId;

    @Column(name = "route_short_name")
    private String shortName;

    @Column(name = "route_long_name")
    private String longName;

    @Column(name = "route_desc")
    private String description;

    @Column(name = "route_type")
    private Type type;

    @Column(name = "route_url")
    private String url;

    @Column(name = "route_color")
    private String color;

    @Column(name = "route_text_color")
    private String textColor;

    @Column(name = "route_sort_order")
    private Integer sortOrder;

    @Column(name = "continuous_pickup")
    private PickupType continuousPickup;

    @Column(name = "continuous_drop_off")
    private DropOffType continuousDropOff;

    public RoutesEntity() {
        super();
    }

    public RoutesEntity(Map<String, String> tuple) {
        super(tuple);
    }

    public String getId() {
        return id;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public String getColor() {
        return color;
    }

    public String getTextColor() {
        return textColor;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public PickupType getContinuousPickup() {
        return continuousPickup;
    }

    public DropOffType getContinuousDropOff() {
        return continuousDropOff;
    }
}
