package com.lld.parkinglot.service;


import com.lld.parkinglot.enums.LevelNo;
import com.lld.parkinglot.enums.Status;
import com.lld.parkinglot.exception.FailedToInitializeLevelException;
import com.lld.parkinglot.model.Level;
import com.lld.parkinglot.model.Space;
import com.lld.parkinglot.model.Vehicle;
import com.lld.parkinglot.repository.ParkingRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

@Service
@Data
public class ParkingService {

    private ParkingRepository parkingRepository;
    private List<Level> levels;

    @Autowired
    public ParkingService(ParkingRepository parkingRepository){
        this.parkingRepository = parkingRepository;
        this.levels = new ArrayList<>();
    }

    public boolean entery(Vehicle vehicle, Level level){
        return false;
    }


    public boolean initializeLevel(Integer maxCapacity, LevelNo levelNo){
        ArrayList<Space> spaces = new ArrayList<>();
        AtomicInteger initialSpaceId = new AtomicInteger(65);

        try {
            Stream.of(maxCapacity).forEach( num -> {

                spaces.add(
                        Space.builder()
                                .level(levelNo)
                                .id((char) initialSpaceId.getAndIncrement() + "-" + num)
                                .status(Status.FREE).build()
                );
            });

            Level level = Level.builder()
                    .id(levelNo)
                    .slots((Space[]) spaces.toArray())
                    .isFull(false)
                    .build();

            levels.add(level);
            return true;

        }catch (Exception e){
            throw new FailedToInitializeLevelException("failed to initialize "+ e.getMessage());
        }


    }

}
