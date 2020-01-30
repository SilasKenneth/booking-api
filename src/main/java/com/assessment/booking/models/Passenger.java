package com.assessment.booking.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "passengers")
public class Passenger {
    @Id
    private UUID passengerId;
    @NotNull
    private String name;
    private String contactNumber;
    public Passenger(){
        this.passengerId = UUID.randomUUID();
    }
}
