package com.assessment.booking.services;

import com.assessment.booking.models.Booking;
import com.assessment.booking.models.Passenger;
import com.assessment.booking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings(){
        List<Booking> bookings = new ArrayList<>();
        bookingRepository.findAll().forEach(bookings::add);
        return bookings;
    }
    public Optional<Booking> getBooking(UUID bookingId){
        return bookingRepository.findById(bookingId);
    }

    public Booking addBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    public Optional<Booking> updateBooking(UUID bookingId, Booking newBooking){
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if(booking.equals(Optional.empty())){
            return booking;
        }
        booking = Optional.ofNullable(newBooking);
        return booking;
    }
}