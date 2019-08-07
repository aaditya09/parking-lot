package com.lld.parkinglot.repository;

import com.lld.parkinglot.enums.LevelNo;
import com.lld.parkinglot.enums.Status;
import com.lld.parkinglot.exception.FailedToInitializeLevelException;
import com.lld.parkinglot.exception.VehicleNotFoundException;
import com.lld.parkinglot.model.Space;
import com.lld.parkinglot.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Aaditya.t on 7/8/19.
 */

@Repository
public class SpaceRepository {
    private EnumMap<LevelNo, List<Space>> spaceMap;


    public SpaceRepository(){
        this.spaceMap = new EnumMap<>(LevelNo.class);
    }

    void insert(LevelNo level, Integer maxCapacity){
        AtomicInteger initialSpaceId = new AtomicInteger(65);
        ArrayList<Space> spaces = new ArrayList<>();
        try {
            IntStream.range(1, maxCapacity).forEach(num -> {
                spaces.add(
                        Space.builder()
                                .level(level)
                                .id(level.name().charAt(0) + "-" + (char) initialSpaceId.getAndIncrement() + "-" + num)
                                .status(Status.FREE).build()
                );
            });

            spaceMap.put(level, spaces);

        } catch (Exception e){
            throw new FailedToInitializeLevelException("failed to initialize level");
        }
    }

    List<Space> get(LevelNo level) {
        return this.spaceMap.get(level);
    }

    List<Space> getByStatusAndLevel(LevelNo level, Status status) {
        List<Space> levelSpaces = spaceMap.get(level);
        return levelSpaces.stream().filter(space -> space.getStatus().equals(status)).collect(Collectors.toList());
    }

    boolean update(Vehicle vehicle, Space space, LevelNo level) {
        List<Space> levelSpaces =  spaceMap.get(level);

        levelSpaces.stream().filter( lspace -> lspace.getId().equalsIgnoreCase(space.getId()))
                .findAny()
                .ifPresent(
                        matchSpace -> {
                            matchSpace.setStatus(Status.ALLOCATED);
                            matchSpace.setAllocationTime(LocalDateTime.now());
                            matchSpace.setVechile(vehicle);
                            matchSpace.getVechile().setSpace(matchSpace);
                        });

        return true;
    }

    Space get(Vehicle vehicle) {
        return vehicle.getSpace();
    }
}
