package com.assessment.booking.services;


import com.assessment.booking.models.Booking;
import com.assessment.booking.models.TripWayPoint;
import com.assessment.booking.repositories.BookingRepository;
import com.assessment.booking.repositories.TripWayPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TripWayPointService {
    @Autowired
    private TripWayPointRepository tripWayPointRepository;

    public List<TripWayPoint> getAllWayPoints(Booking booking){
        return booking.getTripWayPoints();
    }

    public Optional<TripWayPoint> getWaypoint(UUID tripWayPointId){
        return tripWayPointRepository.findById(tripWayPointId);
    }

    public Optional<TripWayPoint> updateWayPoint(UUID wayPointId, TripWayPoint newWayPoint) {
        Optional<TripWayPoint> existing = tripWayPointRepository.findById(wayPointId);
        if(Optional.empty().equals(existing)){
            return existing;
        }
        newWayPoint.setTripWayPointId(existing.map(TripWayPoint::getTripWayPointId).orElse(UUID.randomUUID()));
        newWayPoint.setTripWayPointTimestamp(Instant.now());
        tripWayPointRepository.save(newWayPoint);
        return Optional.of(newWayPoint);
    }
}
