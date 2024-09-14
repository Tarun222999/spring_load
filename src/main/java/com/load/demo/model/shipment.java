package com.load.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String loadingpoint;
    private String unloadingpoint;
    private String producttype;
    private String trucktype;
    private Integer nooftrucks;
    private Double weight;
    private String comment;
    private String shipperid;
    private LocalDate shipmentdate;
}
