package com.lld.parkinglot.model;


import lombok.Data;

@Data
public class Invoice {
    private Vehicle vehicle;
    private String amount;
    private String status;
}
