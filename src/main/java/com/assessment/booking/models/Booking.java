package com.assessment.booking.models;

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "bookings")
@Data
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
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<TripWayPoint> tripWayPoints;

    public Booking(){
        this.createdOn = this.lastModifiedOn = Instant.now();
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
                '}';
    }
}
