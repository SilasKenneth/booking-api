package com.assessment.booking.controllers;


import com.assessment.booking.models.Booking;
import com.assessment.booking.models.Passenger;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/api/bookings")
public class BookingController {

    @GetMapping()
    public  List<Booking> getAllBookings(){

        return new ArrayList<>();
    }

    @PostMapping()
    public Booking createBooking(@RequestBody Booking booking){
        Booking newBooking = new Booking();
        return booking;
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
    public Booking getSpecificBooking(@PathVariable("bookingId") UUID bookingId){
        return new Booking();
    }
}
