package com.lld.parkinglot.service;


import com.lld.parkinglot.enums.LevelNo;
import com.lld.parkinglot.enums.Status;
import com.lld.parkinglot.exception.FailedToInitializeLevelException;
import com.lld.parkinglot.model.Car;
import com.lld.parkinglot.model.Level;
import com.lld.parkinglot.model.Space;
import com.lld.parkinglot.model.Vehicle;
import com.lld.parkinglot.repository.ParkingRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
@Data
public class ParkingService {
    private LevelService levelService;

    @Autowired
    public ParkingService(LevelService levelService){
        this.levelService = levelService;
    }

    public boolean entery(Vehicle vehicle, Level level){
        return false;
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
}
