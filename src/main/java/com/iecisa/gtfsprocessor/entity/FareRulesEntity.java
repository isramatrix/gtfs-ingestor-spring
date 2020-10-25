package com.iecisa.gtfsprocessor.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "fare_rules")
public class FareRulesEntity extends GtfsEntity
{
    @Id
    @GeneratedValue
    long uuid;

    @Column(name = "fare_id")
    private String fareId;

    @Column(name = "route_id")
    private String routeId;

    @Column(name = "origin_id")
    private String originId;

    @Column(name = "destination_id")
    private String destinationId;

    @Column(name = "contains_id")
    private String containsId;

    public FareRulesEntity() { }

    public FareRulesEntity(Map<String, String> tuple)
    {
        super(tuple);
    }

    public String getFareId() {
        return fareId;
    }

    public void setFareId(String fareId) {
        this.fareId = fareId;
    }

    @Nullable
    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(@Nullable String routeId) {
        this.routeId = routeId;
    }

    @Nullable
    public String getOriginId() {
        return originId;
    }

    public void setOriginId(@Nullable String originId) {
        this.originId = originId;
    }

    @Nullable
    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(@Nullable String destinationId) {
        this.destinationId = destinationId;
    }

    @Nullable
    public String getContainsId() {
        return containsId;
    }

    public void setContainsId(@Nullable String containsId) {
        this.containsId = containsId;
    }
}
