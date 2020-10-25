package com.iecisa.gtfsprocessor.entity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "calendar_dates")
public class CalendarDatesEntity extends GtfsEntity
{
    @Id
    @GeneratedValue
    long uuid;

    public enum Type {
        ADDED(1), REMOVED(2);
        public final int id;
        Type(int id) { this.id = id; }
        public static Type value(int id) {
            for (Type t : Type.values())
                if (t.id == id) return t;
            return null;
        }
    }

    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "date")
    private String date;

    @Column(name = "exception_type")
    private Integer exceptionType;

    public CalendarDatesEntity() {
        super();
    }

    public CalendarDatesEntity(Map<String, String> tuple) {
        super(tuple);
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getDate() {
        return date;
    }

    public Type getExceptionType() {
        return Type.value(exceptionType);
    }
}
