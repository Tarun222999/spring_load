package com.load.demo.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class shipmentUpdateRequest {

    private Integer id;
    private String loadingpoint;
    private String unloadingpoint;
    private String producttype;
    private String trucktype;
    private Integer nooftrucks;
    private Double weight;
    private String comment;
    private String shipperid;
    private String shipmentdate;
}
