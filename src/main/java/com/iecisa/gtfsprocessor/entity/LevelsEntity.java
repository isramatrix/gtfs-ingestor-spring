package com.iecisa.gtfsprocessor.entity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "levels")
public class LevelsEntity extends GtfsEntity
{
    @Id
    @GeneratedValue
    long uuid;

    @Column(name = "level_id")
    private String id;

    @Column(name = "level_index")
    private Float index;

    @Column(name = "level_name")
    private String name;

    public LevelsEntity() {
        super();
    }

    public LevelsEntity(Map<String, String> tuple) {
        super(tuple);
    }

    public String getId() {
        return id;
    }

    public Float getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
