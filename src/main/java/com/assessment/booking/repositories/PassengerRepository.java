package com.assessment.booking.repositories;

import com.assessment.booking.models.Passenger;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PassengerRepository extends CrudRepository<Passenger, UUID> {
}
