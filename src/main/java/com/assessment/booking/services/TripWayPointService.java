package com.assessment.booking.services;


import com.assessment.booking.models.Booking;
import com.assessment.booking.models.TripWayPoint;
import com.assessment.booking.repositories.BookingRepository;
import com.assessment.booking.repositories.TripWayPointRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class TripWayPointService {
    @Autowired
    private TripWayPointRepository tripWayPointRepository;
    @Autowired
    private BookingRepository bookingRepository;
    public List<TripWayPoint> getAllWayPoints(Booking booking){
        return booking.getTripWayPoints();
    }

    @Transactional
    public TripWayPoint getWaypoint(UUID tripWayPointId){
        TripWayPoint tripWayPoint = tripWayPointRepository.findById(tripWayPointId).orElse(null);
        if(tripWayPoint == null){
            return null;
        }
        Hibernate.initialize(tripWayPoint.getBooking());
        return tripWayPoint;
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

    public TripWayPoint addWayPoint(TripWayPoint wayPoint, UUID bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if(!booking.isPresent()){
            return null;
        }
        wayPoint.setBooking(booking.get());
        tripWayPointRepository.save(wayPoint);
        return wayPoint;
    }
}
