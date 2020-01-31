package com.assessment.booking.controllers;

import com.assessment.booking.models.TripWayPoint;
import com.assessment.booking.services.TripWayPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/waypoints")
public class TripWayPointController {
    @Autowired
    private TripWayPointService tripWayPointService;

    @GetMapping(value = "/{wayPointId}")
    public TripWayPoint getWayPoint(@PathVariable("wayPointId")UUID wayPointId){
        return tripWayPointService.getWaypoint(wayPointId);
    }

    @PutMapping(value = "/{wayPointId}/update")
    public Optional<TripWayPoint> updateWayPoint(@RequestBody TripWayPoint updatedWayPoint, @PathVariable("wayPointId") UUID wayPointId){
        return tripWayPointService.updateWayPoint(wayPointId, updatedWayPoint);
    }
}
