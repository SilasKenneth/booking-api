package com.assessment.booking.repositories;

import com.assessment.booking.models.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Transactional(timeout = 10)
public interface BookingRepository extends CrudRepository<Booking, UUID> {
    @Override
    @Transactional
    Optional<Booking> findById(UUID bookingId);

    @Transactional
    Collection<Booking> findAll();
}
