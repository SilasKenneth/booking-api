package com.assessment.booking.services;

import com.assessment.booking.models.Passenger;
import com.assessment.booking.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getPassengers(){
        List<Passenger> passengers = new ArrayList<>();
        passengerRepository.findAll().forEach(passengers::add);
        return passengers;
    }

    public Optional<Passenger> getPassenger(UUID passengerId){
        return passengerRepository.findById(passengerId);
    }

    public Passenger addPassenger(Passenger passenger){
        return passengerRepository.save(passenger);
    }


}
