package com.iecisa.gtfsprocessor.entity;

import com.iecisa.gtfsprocessor.entity.enums.DropOffType;
import com.iecisa.gtfsprocessor.entity.enums.PickupType;

import javax.persistence.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Map;

import static java.lang.Integer.parseInt;

@Entity
@Table(name = "stop_times")
public class StopTimesEntity extends GtfsEntity
{
    @Id
    @GeneratedValue
    long uuid;

    public enum Timepoint {
        ESTIMATED(0), EXACT(1);
        public final int id;
        Timepoint(int id) { this.id = id; }
        public static Timepoint value(int id) {
            for (Timepoint t : Timepoint.values())
                if (t.id == id) return t;
            return null;
        }
    }

    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

    @Column(name = "trip_id")
    private String tripId;

    @Column(name = "arrival_time")
    private Time arrivalTime;

    @Column(name = "departure_time")
    private Time departureTIme;

    @Column(name = "stop_id")
    private String stopId;

    @Column(name = "stop_sequence")
    private Integer sequence;

    @Column(name = "stop_headsign")
    private String headsign;

    @Column(name = "pickup_type")
    private PickupType pickupType;

    @Column(name = "drop_off_type")
    private DropOffType dropOffType;

    @Column(name = "continuous_pickup")
    private PickupType continuousPickup;

    @Column(name = "continuous_drop_off")
    private DropOffType continuousDropOff;

    @Column(name = "shape_dist_travelled")
    private Float shapeDistanceTraveled;

    @Column(name = "timepoint")
    private Timepoint timepoint;

    public StopTimesEntity() {
        super();
    }

    public StopTimesEntity(Map<String, String> tuple)
    {
        super(tuple);

        if (tuple.containsKey("arrival_time"))
            try {
                arrivalTime = new Time(TIME_FORMAT.parse(tuple.get("arrival_time")).getTime());
            } catch (Exception ignored) { }

        if (tuple.containsKey("departure_time"))
            try {
                departureTIme = new Time(TIME_FORMAT.parse(tuple.get("departure_time")).getTime());
            } catch (Exception ignored) { }

        if (tuple.containsKey("pickup_type"))
            pickupType = PickupType.value(parseInt(tuple.get("pickup_type")));
        else pickupType = PickupType.REGULAR;

        if (tuple.containsKey("drop_off_type"))
            dropOffType = DropOffType.value(parseInt(tuple.get("drop_off_type")));
        else dropOffType = DropOffType.REGULAR;

        if (tuple.containsKey("continuous_pickup"))
            continuousPickup = PickupType.value(parseInt(tuple.get("continuous_pickup")));
        else continuousPickup = PickupType.NOT_AVAILABLE;

        if (tuple.containsKey("pickup_type"))
            continuousDropOff = DropOffType.value(parseInt(tuple.get("pickup_type")));
        else continuousDropOff = DropOffType.NOT_AVAILABLE;

        if (tuple.containsKey("timepoint"))
            timepoint = Timepoint.value(parseInt(tuple.get("timepoint")));
        else timepoint = Timepoint.EXACT;
    }
}
