package com.assessment.booking.controllers;


import com.assessment.booking.models.Booking;
import com.assessment.booking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

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
    public Booking getSpecificBooking(@PathVariable("bookingId") UUID bookingId){
        return new Booking();
    }
}
