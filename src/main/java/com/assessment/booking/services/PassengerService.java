package com.assessment.booking.services;

import com.assessment.booking.models.Passenger;
import com.assessment.booking.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> all(){
        List<Passenger> passengers = new ArrayList<>();
        passengerRepository.findAll().forEach(passengers::add);
        return passengers;
    }
}
