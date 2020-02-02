package com.assessment.booking.repositories;

import com.assessment.booking.models.TripWayPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Transactional
public interface TripWayPointRepository extends CrudRepository<TripWayPoint, UUID> {

    @Transactional(timeout = 10)
    Collection<TripWayPoint> findByBookingBookingId(@Param("bookingId") UUID bookingId);
    Optional<TripWayPoint> findById(UUID tripWayPointId);
}
