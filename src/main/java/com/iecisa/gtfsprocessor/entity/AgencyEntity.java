package com.iecisa.gtfsprocessor.entity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "agency")
public class AgencyEntity extends GtfsEntity
{
    @Id
    @GeneratedValue
    long uuid;

    @Column(name = "agency_id")
    private String id;

    @Column(name = "agency_name")
    private String name;

    @Column(name = "agency_url")
    private String url;

    @Column(name = "agency_timezone")
    private String timezone;

    @Column(name = "agency_lang")
    private String language;

    @Column(name = "agency_phone")
    private String phone;

    @Column(name = "agency_fare_url")
    private String fareUrl;

    @Column(name = "agency_email")
    private String email;

    public AgencyEntity() {
        super();
    }

    public AgencyEntity(Map<String, String> tuple) {
        super(tuple);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getLanguage() {
        return language;
    }

    public String getPhone() {
        return phone;
    }

    public String getFareUrl() {
        return fareUrl;
    }

    public String getEmail() {
        return email;
    }
}
