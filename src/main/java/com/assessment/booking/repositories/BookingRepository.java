package com.assessment.booking.repositories;

import com.assessment.booking.models.Booking;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BookingRepository extends CrudRepository<Booking, UUID> {

}
