package com.iecisa.gtfsprocessor.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name = "calendar")
public class CalendarEntity extends GtfsEntity
{
    @Id
    @GeneratedValue
    long uuid;

    @Column(name = "service_id")
    private String id;

    @Column(name = "monday")
    private Integer monday;

    @Column(name = "tuesday")
    private Integer tuesday;

    @Column(name = "wednesday")
    private Integer wednesday;

    @Column(name = "thursday")
    private Integer thursday;

    @Column(name = "friday")
    private Integer friday;

    @Column(name = "saturday")
    private Integer saturday;

    @Column(name = "sunday")
    private Integer sunday;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    public CalendarEntity() {
        super();
    }

    public CalendarEntity(Map<String, String> tuple) {
        super(tuple);
    }

    public String getId() {
        return id;
    }

    public boolean getMonday() {
        return monday == 1;
    }

    public boolean getTuesday() {
        return tuesday == 1;
    }

    public boolean getWednesday() {
        return wednesday == 1;
    }

    public boolean getThursday() {
        return thursday == 1;
    }

    public boolean getFriday() {
        return friday == 1;
    }

    public boolean getSaturday() {
        return saturday == 1;
    }

    public boolean getSunday() {
        return sunday == 1;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
