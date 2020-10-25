package com.iecisa.gtfsprocessor.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Map;

@Entity
@Table(name = "transfers")
public class TransfersEntity extends GtfsEntity
{
    @Id
    @GeneratedValue
    long uuid;

    public enum ServiceType {
        FREQUENCY_BASED(0), SCHEDULE_BASED(1);
        public final int id;
        ServiceType(int id) { this.id = id; }
        public static ServiceType value(int id) {
            for (ServiceType t : ServiceType.values())
                if (t.id == id) return t;
            return null;
        }
    }

    @Column(name = "trip_id")
    private String tripId;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "end_time")
    private Time endTime;

    @Column(name = "headway_secs")
    private Integer headwaySeconds;

    @Column(name = "exact_times")
    private ServiceType exactTimes;

    public TransfersEntity() {
        super();
    }

    public TransfersEntity(Map<String, String> tuple) {
        super(tuple);
    }

    public String getTripId() {
        return tripId;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public Integer getHeadwaySeconds() {
        return headwaySeconds;
    }

    public ServiceType getExactTimes() {
        return exactTimes;
    }
}
