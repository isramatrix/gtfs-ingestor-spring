package com.iecisa.gtfsprocessor.entity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "pathways")
public class PathwaysEntity extends GtfsEntity
{
    @Id
    @GeneratedValue
    long uuid;

    public enum Pathway {
        WALKWAY(1), STAIRS(2), MOVING_SIDEWALK(3), ESCALATOR(4), ELEVATOR(5), FARE_GATE(6), EXIT_GATE(7);
        public final int id;
        Pathway(int id) { this.id = id; }
        public static Pathway value(int id) {
            for (Pathway t : Pathway.values())
                if (t.id == id) return t;
            return null;
        }
    }

    public enum Direction {
        UNIDIRECTIONAL(0), BIDIRECTIONAL(1);
        public final int id;
        Direction(int id) { this.id = id; }
        public static Direction value(int id) {
            for (Direction t : Direction.values())
                if (t.id == id) return t;
            return null;
        }
    }

    @Column(name = "pathway_id")
    private String id;

    @Column(name = "from_stop_id")
    private String fromStopId;

    @Column(name = "to_stop_id")
    private String toStopId;

    @Column(name = "pathway_mode")
    private Pathway pathwayMode;

    @Column(name = "is_bidirectional")
    private Direction isBidirectional;

    @Column(name = "length")
    private Float length;

    @Column(name = "traversal_time")
    private Integer traversalTime;

    @Column(name = "stair_count")
    private Integer stairCount;

    @Column(name = "max_slope")
    private Float maxSlope;

    @Column(name = "min_width")
    private Float minWidth;

    @Column(name = "signposted_as")
    private String signpostedAs;

    @Column(name = "reversed_signposted_as")
    private String reversedSignpostedAs;

    public PathwaysEntity() {
        super();
    }

    public PathwaysEntity(Map<String, String> tuple) {
        super(tuple);
    }

    public String getId() {
        return id;
    }

    public String getFromStopId() {
        return fromStopId;
    }

    public String getToStopId() {
        return toStopId;
    }

    public Pathway getPathwayMode() {
        return pathwayMode;
    }

    public Direction getIsBidirectional() {
        return isBidirectional;
    }

    public Float getLength() {
        return length;
    }

    public Integer getTraversalTime() {
        return traversalTime;
    }

    public Integer getStairCount() {
        return stairCount;
    }

    public Float getMaxSlope() {
        return maxSlope;
    }

    public Float getMinWidth() {
        return minWidth;
    }

    public String getSignpostedAs() {
        return signpostedAs;
    }

    public String getReversedSignpostedAs() {
        return reversedSignpostedAs;
    }
}
