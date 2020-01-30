package com.assessment.booking.repositories;

import com.assessment.booking.models.Passenger;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface PassengerRepository extends Repository<Passenger, UUID> {
}
