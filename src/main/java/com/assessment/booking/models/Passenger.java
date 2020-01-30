package com.assessment.booking.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "passengers")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID passengerId;
    @NotNull
    private String name;
    private String contactNumber;
    public Passenger(){
        this.passengerId = UUID.randomUUID();
    }
}
