package com.lld.parkinglot.service;


import com.lld.parkinglot.enums.InvoiceStatus;
import com.lld.parkinglot.enums.LevelNo;
import com.lld.parkinglot.enums.Status;
import com.lld.parkinglot.exception.FailedToInitializeLevelException;
import com.lld.parkinglot.exception.FreeSpaceNotFoundException;
import com.lld.parkinglot.exception.PaymentFaildExeption;
import com.lld.parkinglot.model.*;
import com.lld.parkinglot.repository.ParkingRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
@Data
@Slf4j
public class ParkingService {
    private LevelService levelService;
    private InvoiceService invoiceService;

    @Autowired
    public ParkingService(LevelService levelService, InvoiceService invoiceService){
        this.levelService = levelService;
        this.invoiceService = invoiceService;
    }


    public void initializeLevel(Integer maxCapacity, LevelNo levelNo){
        levelService.create(levelNo, maxCapacity);
    }

    public List<Space> getAllSpace(LevelNo level){
     return levelService.find(level);
    }


    public List<Space> getFreeSpace(LevelNo level){
        return levelService.find(level, Status.FREE);
    }

    public List<Space> getAllocatedSpace(LevelNo level){
        return levelService.find(level, Status. ALLOCATED);
    }


    public boolean park(Vehicle vehicle , LevelNo level){
        List<Space> freeSpace = levelService.find(level, Status.FREE);

        if(freeSpace.isEmpty()){
            throw new FreeSpaceNotFoundException("Free Space not found on : " + level.name() + " parking failed for : " + vehicle.getNumber());
        }

        return levelService.park(vehicle, freeSpace.get(0), level);
    }

    public boolean exit(Vehicle vehicle){
        return levelService.exit(vehicle);
    }

    public Space getVehicleParkingInfo(Vehicle vehicle) {
        return levelService.find(vehicle);
    }

    public boolean payInvoice(Vehicle vehicle) {
        Invoice invoice = invoiceService.getInvoice(vehicle);
        log.info("Raised invoice : " + invoice.toString());
        boolean paidSuccessfully = true;
        if (paidSuccessfully){
            invoice.setStatus(InvoiceStatus.PAID);
            vehicle.setIsCharagesPaid(true);
            log.info("Paid invoice : " + invoice.toString());
            return true;
        } else {
            throw new PaymentFaildExeption("Payment declined, Try again");
        }
    }
}
