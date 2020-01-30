package com.assessment.booking.services;


import com.assessment.booking.models.Booking;
import com.assessment.booking.models.TripWayPoint;
import com.assessment.booking.repositories.BookingRepository;
import com.assessment.booking.repositories.TripWayPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripWayPointService {
    @Autowired
    private TripWayPointRepository tripWayPointRepository;

    public List<TripWayPoint> getAllBookings(){
        List<TripWayPoint> bookings = new ArrayList<>();
        tripWayPointRepository.findAll().forEach(bookings::add);
        return bookings;
    }
}
