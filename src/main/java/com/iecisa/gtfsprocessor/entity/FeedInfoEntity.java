package com.iecisa.gtfsprocessor.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name = "feed_info")
public class FeedInfoEntity extends GtfsEntity
{
    @Id
    @GeneratedValue
    long uuid;

    @Column(name = "feed_publisher_name")
    private String publisherName;

    @Column(name = "feed_publisher_url")
    private String publisherUrl;

    @Column(name = "feed_lang")
    private String language;

    @Column(name = "default_lang")
    private String defaultLanguage;

    @Column(name = "feed_start_date")
    private Date startDate;

    @Column(name = "feed_end_date")
    private Date endDate;

    @Column(name = "feed_version")
    private String version;

    @Column(name = "feed_contact_email")
    private String contactEmail;

    @Column(name = "feed_contact_url")
    private String contactUrl;

    public FeedInfoEntity() {
        super();
    }

    public FeedInfoEntity(Map<String, String> tuple) {
        super(tuple);
    }

    public String getPublisherName() {
        return publisherName;
    }

    public String getPublisherUrl() {
        return publisherUrl;
    }

    public String getLanguage() {
        return language;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getVersion() {
        return version;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactUrl() {
        return contactUrl;
    }
}
