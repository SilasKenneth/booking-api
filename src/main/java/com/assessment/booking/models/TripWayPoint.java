package com.assessment.booking.models;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "trip_way_points")
public class TripWayPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID tripWayPointId;
    @ManyToOne
    private Booking booking;
    private Boolean lastStop = false;
    private String locality;
    private Double lat;
    private Double lng;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Instant tripWayPointTimestamp;

    public TripWayPoint(){
        this.tripWayPointTimestamp = Instant.now();
    }

    public UUID getTripWayPointId() {
        return tripWayPointId;
    }

    public Booking getBooking() {
        return booking;
    }

    public Boolean getLastStop() {
        return lastStop;
    }

    public String getLocality() {
        return locality;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void setLastStop(Boolean lastStop) {
        this.lastStop = lastStop;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Instant getTripWayPointTimestamp() {
        return tripWayPointTimestamp;
    }

    public void setTripWayPointId(UUID tripWayPointId) {
        this.tripWayPointId = tripWayPointId;
    }

    public void setTripWayPointTimestamp(Instant tripWayPointTimestamp) {
        this.tripWayPointTimestamp = tripWayPointTimestamp;
    }
}
