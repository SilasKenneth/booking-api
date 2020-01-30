package com.assessment.booking.models;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "trip_way_points")
public class TripWayPoint {
    @Id
    private UUID tripWayPointId;
    @ManyToOne
    private Booking booking;
    private Boolean lastStop = false;
    private String locality;
    private Double lat;
    private Double lng;
    private Instant tripWayPointTimestamp;

    public TripWayPoint(){
        this.tripWayPointId = UUID.randomUUID();
        this.tripWayPointTimestamp = Instant.now();
    }
}
