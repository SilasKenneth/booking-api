package com.assessment.booking.repositories;

import com.assessment.booking.models.TripWayPoint;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface TripWayPointRepository extends Repository<TripWayPoint, UUID> {

}
