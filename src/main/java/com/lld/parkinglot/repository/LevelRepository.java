package com.lld.parkinglot.repository;

import com.lld.parkinglot.enums.LevelNo;
import com.lld.parkinglot.enums.Status;
import com.lld.parkinglot.model.Space;
import com.lld.parkinglot.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Aaditya.t on 7/8/19.
 */

@Repository
public class LevelRepository {

    private SpaceRepository spaceRepository;

    @Autowired
    public LevelRepository(SpaceRepository spaceRepository){
        this.spaceRepository = spaceRepository;
    }


    public void insert(LevelNo level, Integer maxCapacity){
       spaceRepository.insert(level, maxCapacity);
    }

    public List<Space> get(LevelNo level) {
        return spaceRepository.get(level);
    }

    public List<Space> getByStatusAndLevel(LevelNo level, Status status) {
        return spaceRepository.getByStatusAndLevel(level, status);

    }

    public boolean park(Vehicle vehicle, Space space , LevelNo level) {
        return spaceRepository.update(vehicle, space, level);
    }

    public Space find(Vehicle vehicle) {
        return spaceRepository.get(vehicle);
    }
}
