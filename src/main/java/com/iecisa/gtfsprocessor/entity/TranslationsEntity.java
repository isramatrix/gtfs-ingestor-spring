package com.iecisa.gtfsprocessor.entity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "translations")
public class TranslationsEntity extends GtfsEntity
{
    @Id
    @GeneratedValue
    long uuid;

    private enum Table {
        AGENCY("agency"), STOPS("stops"), ROUTES("routes"), TRIPS("trips"), STOP_TIMES("stop_times"), FEED_INFO("feed_info"), PATHWAYS("pathways"), LEVELS("levels"), ATTRIBUTIONS("attributions");
        public final String id;
        Table(String id) { this.id = id; }
        public static Table value(String id) {
            for (Table t : Table.values())
                if (t.id.equals(id)) return t;
            return null;
        }
    }

    @Column(name = "table_name")
    private Table tableName;

    @Column(name = "field_name")
    private String fieldName;

    @Column(name = "language")
    private String language;

    @Column(name = "translation")
    private String translation;

    @Column(name = "record_id")
    private String recordId;

    @Column(name = "record_sub_id")
    private String secondaryRecordId;

    @Column(name = "field_value")
    private String fieldValue;

    public TranslationsEntity() {
        super();
    }

    public TranslationsEntity(Map<String, String> tuple) {
        super(tuple);
    }
}
