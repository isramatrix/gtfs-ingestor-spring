package com.iecisa.gtfsprocessor.entity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "fare_attributes")
public class FareAttributesEntity extends GtfsEntity
{
    @Id
    @GeneratedValue
    long uuid;

    public enum Method {
        ON_BOARD(0), BEFORE_BOARD(1);
        public final int id;
        Method(int id) { this.id = id; }
        public static Method value(int id) {
            for (Method t : Method.values())
                if (t.id == id) return t;
            return null;
        }
    }

    public enum Transfers {
        NOT_ALLOWED(0), ONCE(1), TWICE(2);
        public final int id;
        Transfers(int id) { this.id = id; }
        public static Transfers value(int id) {
            for (Transfers t : Transfers.values())
                if (t.id == id) return t;
            return null;
        }
    }

    @Column(name = "fare_id")
    private String id;

    @Column(name = "price")
    private Float price;

    @Column(name = "currency_type")
    private String currencyType;

    @Column(name = "payment_method")
    private Integer paymentMethod;

    @Column(name = "transfers")
    private Integer transfers;

    @Column(name = "agency_id")
    private String agencyId;

    @Column(name = "transfer_duration")
    private Integer transferDuration;

    public FareAttributesEntity() {
        super();
    }

    public FareAttributesEntity(Map<String, String> tuple) {
        super(tuple);
    }

    public String getId() {
        return id;
    }

    public Float getPrice() {
        return price;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public Method getPaymentMethod() {
        return Method.value(paymentMethod);
    }

    public Transfers getTransfers() {
        return Transfers.value(transfers);
    }

    public String getAgencyId() {
        return agencyId;
    }

    public Integer getTransferDuration() {
        return transferDuration;
    }
}
