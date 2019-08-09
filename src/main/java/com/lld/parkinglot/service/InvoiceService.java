package com.lld.parkinglot.service;


import com.lld.parkinglot.enums.InvoiceStatus;
import com.lld.parkinglot.enums.Type;
import com.lld.parkinglot.model.Invoice;
import com.lld.parkinglot.model.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

@Service
@Slf4j
public class InvoiceService {
    private static final Integer TWO_WHEELER_PRICING = 10;
    private static final Integer FOUR_WHEELER_PRICING = 10;

    private PaymentService paymentService;

    @Autowired
    public InvoiceService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    Invoice getInvoice(Vehicle vehicle) {
        Long parkingTimeInSec = getParkingTime(vehicle);
        if (vehicle.getType().equals(Type.TWO_WHEELER)){
            return  getVehicleInvoice(parkingTimeInSec, vehicle, TWO_WHEELER_PRICING);
        } else {
            return  getVehicleInvoice(parkingTimeInSec, vehicle, FOUR_WHEELER_PRICING);
        }
    }

    private Invoice getVehicleInvoice(Long parkingTimeInSec, Vehicle vehicle, Integer unitParkingPrice) {
        return Invoice.builder()
                .vehicle(vehicle)
                .amount(String.valueOf(parkingTimeInSec * unitParkingPrice))
                .status(InvoiceStatus.RAISED)
                .build();
    }

    private Long getParkingTime(Vehicle vehicle) {
        return Duration.between(vehicle.getSpace().getAllocationTime(), LocalDateTime.now()).toMillis();
    }


     boolean payInvoice(Invoice invoice) {
        return paymentService.pay(invoice);
    }
}
