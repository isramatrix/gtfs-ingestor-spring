package com.iecisa.gtfsprocessor.entity;

import com.iecisa.gtfsprocessor.entity.enums.Accessibility;
import com.iecisa.gtfsprocessor.entity.enums.BikesAllow;
import com.iecisa.gtfsprocessor.entity.enums.Direction;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "trips")
public class TripsEntity extends GtfsEntity
{
    @Id
    @GeneratedValue
    long uuid;

    @Column(name = "route_id")
    private String routeId;

    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "trip_id")
    private String id;

    @Column(name = "trip_headsign")
    private String headsign;

    @Column(name = "trip_short_name")
    private String name;

    @Column(name = "direction_id")
    private Direction directionId;

    @Column(name = "block_id")
    private String blockId;

    @Column(name = "shape_id")
    private String shapeId;

    @Column(name = "wheelchair_accessible")
    private Accessibility wheelchairAccessible;

    @Column(name = "bikes_allowed")
    private BikesAllow bikesAllowed;

    public TripsEntity() {
        super();
    }

    public TripsEntity(Map<String, String> tuple) {
        super(tuple);
    }

    public String getRouteId() {
        return routeId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getId() {
        return id;
    }

    public String getHeadsign() {
        return headsign;
    }

    public String getName() {
        return name;
    }

    public Direction getDirectionId() {
        return directionId;
    }

    public String getBlockId() {
        return blockId;
    }

    public String getShapeId() {
        return shapeId;
    }

    public Accessibility getWheelchairAccessible() {
        return wheelchairAccessible;
    }

    public BikesAllow getBikesAllowed() {
        return bikesAllowed;
    }
}
