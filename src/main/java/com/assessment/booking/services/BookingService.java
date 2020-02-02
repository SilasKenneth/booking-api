package com.assessment.booking.services;

import com.assessment.booking.models.Booking;
import com.assessment.booking.models.Passenger;
import com.assessment.booking.repositories.BookingRepository;
import org.hibernate.Hibernate;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.internal.SessionFactoryBuilderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    public Collection<Booking> getAllBookings(){
       Collection<Booking> bookings = bookingRepository.findAll();
       bookings.forEach(item -> Hibernate.initialize(item.getTripWayPoints()));
       return bookings;
    }
    @Transactional
    public Booking getBooking(UUID bookingId){
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if(!booking.isPresent()){
            return null;
        }
        Booking result = booking.get();
        Hibernate.initialize(result.getTripWayPoints());
        return result;
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