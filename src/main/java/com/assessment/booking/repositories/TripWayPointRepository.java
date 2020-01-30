package com.assessment.booking.repositories;

import com.assessment.booking.models.TripWayPoint;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TripWayPointRepository extends CrudRepository<TripWayPoint, UUID> {

}
