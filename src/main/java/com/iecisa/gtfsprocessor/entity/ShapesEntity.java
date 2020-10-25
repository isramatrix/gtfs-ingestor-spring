package com.iecisa.gtfsprocessor.entity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "shapes")
public class ShapesEntity extends GtfsEntity
{
    @Id
    @GeneratedValue
    long uuid;

    @Column(name = "shape_id")
    private String id;

    @Column(name = "shape_pt_lat")
    private Double latitude;

    @Column(name = "shape_pt_lon")
    private Double longitude;

    @Column(name = "shape_pt_sequence")
    private Integer sequence;

    @Column(name = "shape_dist_traveled")
    private Float distanceTraveled;

    public ShapesEntity() { super(); }

    public ShapesEntity(Map<String, String> tuple) {
        super(tuple);
    }

    public String getId() {
        return id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Integer getSequence() {
        return sequence;
    }

    public Float getDistanceTraveled() {
        return distanceTraveled;
    }
}