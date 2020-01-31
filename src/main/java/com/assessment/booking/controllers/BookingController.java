package com.assessment.booking.controllers;


import com.assessment.booking.models.Booking;
import com.assessment.booking.models.TripWayPoint;
import com.assessment.booking.services.BookingService;
import com.assessment.booking.services.TripWayPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping(value = "/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private TripWayPointService tripWayPointService;

    @GetMapping("")
    public  List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @PostMapping("")
    public Booking createBooking(@RequestBody Booking booking){
        System.out.println("Hello");
        return bookingService.addBooking(booking);
    }

    @PutMapping(value = "/{bookingId}/update")
    public Booking updateBooking(@RequestBody Booking booking, @PathVariable("bookingId") UUID bookingId){
        return booking;
    }

    @DeleteMapping(value = "/{bookingId}/delete")
    public Booking deleteBooking(@PathVariable("bookingId") UUID bookingId){
        return new Booking();
    }

    @GetMapping(value = "/{bookingId}")
    public Optional<Booking> getSpecificBooking(@PathVariable("bookingId") UUID bookingId){
        return bookingService.getBooking(bookingId);
    }

    @GetMapping(value = "/{bookingId}/waypoints")
    public List<TripWayPoint> getTripWayPoints(@PathVariable("bookingId") UUID bookingId){
        Optional<Booking> booking = bookingService.getBooking(bookingId);
        if(!booking.isPresent()){
            return new ArrayList<>();
        }
        System.out.println(booking.get());
        return tripWayPointService.getAllWayPoints(booking.get());
    }

    @PostMapping(value = "/{bookingId}/waypoints")
    public TripWayPoint addTripWayPoint(@RequestBody TripWayPoint wayPoint, @PathVariable("bookingId")UUID bookingId){
        return tripWayPointService.addWayPoint(wayPoint, bookingId);
    }
}
