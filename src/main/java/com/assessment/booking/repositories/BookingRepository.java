package com.assessment.booking.repositories;

import com.assessment.booking.models.Booking;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface BookingRepository extends Repository<Booking, UUID> {

}
