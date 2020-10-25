package com.iecisa.gtfsprocessor.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "attributions")
public class AttributionsEntity extends GtfsEntity
{
    @Id
    @GeneratedValue
    long uuid;

    public enum Role {
        HAS_NOT_ROLE(0), HAS_ROLE(1);
        public final int id;
        Role(int id) { this.id = id; }
        public static Role value(int id) {
            for (Role t : Role.values())
                if (t.id == id) return t;
            return null;
        }
    }

    @Column(name = "attribution_id")
    private String id;

    @Column(name = "agency_id")
    private String agencyId;

    @Column(name = "route_id")
    private String routeId;

    @Column(name = "trip_id")
    private String tripId;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "is_producer")
    private Integer isProducer;

    @Column(name = "is_operator")
    private Integer isOperator;

    @Column(name = "is_authority")
    private Integer isAuthority;

    @Column(name = "attribution_url")
    private String url;

    @Column(name = "attribution_email")
    private String email;

    @Column(name = "attribution_phone")
    private String phone;

    public AttributionsEntity() {
        super();
    }

    public AttributionsEntity(Map<String, String> tuple) {
        super(tuple);
    }

    public String getId() {
        return id;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public String getRouteId() {
        return routeId;
    }

    public String getTripId() {
        return tripId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public Role getIsProducer() {
        return Role.value(isProducer);
    }

    public Role getIsOperator() {
        return Role.value(isOperator);
    }

    public Role getIsAuthority() {
        return Role.value(isAuthority);
    }

    public String getUrl() {
        return url;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
