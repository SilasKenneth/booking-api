package com.assessment.booking.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "trip_way_points")
@Data
public class TripWayPoint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trip_way_point_id")
    private UUID tripWayPointId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Booking booking;
    private Boolean lastStop = false;
    private String locality;
    private Double lat;
    private Double lng;

    @CreationTimestamp
    private Instant tripWayPointTimestamp;

    public TripWayPoint(){}
}
