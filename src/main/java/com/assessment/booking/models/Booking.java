package com.assessment.booking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.databind.JsonMappingException;

@Entity
@Table(name = "bookings")
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID bookingId;
    private OffsetDateTime pickupTime;
    private Boolean asap = true;
    private Integer waitingTime;
    private BigDecimal price;
    private Integer rating;
    private String passengerName;
    private String passengerContactNumber;
    private Integer noOfPassengers;
    private Instant createdOn;
    private Instant lastModifiedOn;
    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TripWayPoint> tripWayPoints;

    public Booking(){
        this.createdOn = this.lastModifiedOn = Instant.now();
    }
    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerContactNumber() {
        return passengerContactNumber;
    }

    public void setPassengerContactNumber(String passengerContactNumber) {
        this.passengerContactNumber = passengerContactNumber;
    }

    public Integer getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(Integer noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }
    public UUID getBookingId() {
        return bookingId;
    }

    public OffsetDateTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(OffsetDateTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Boolean getAsap() {
        return asap;
    }

    public void setAsap(Boolean asap) {
        this.asap = asap;
    }

    public Integer getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Integer waitingTime) {
        this.waitingTime = waitingTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public Instant getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Instant lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public List<TripWayPoint> getTripWayPoints() {
        return this.tripWayPoints;
    }

    public void setTripWayPoints(List<TripWayPoint> tripWayPoints) {
        this.tripWayPoints = tripWayPoints;
    }

    public void addTripWayPoint(TripWayPoint tripWayPoint){
        this.tripWayPoints.add(tripWayPoint);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", pickupTime=" + pickupTime +
                ", asap=" + asap +
                ", waitingTime=" + waitingTime +
                ", price=" + price +
                ", rating=" + rating +
                ", createdOn=" + createdOn +
                ", lastModifiedOn=" + lastModifiedOn +
                ", tripWayPoints=" + tripWayPoints +
                '}';
    }
}
