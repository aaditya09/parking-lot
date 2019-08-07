package com.lld.parkinglot.repository;

import com.lld.parkinglot.enums.LevelNo;
import com.lld.parkinglot.model.Level;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class ParkingRepository {

    private List<Level> levels;

    public ParkingRepository(){
        this.levels = new ArrayList<>();
    }



    //public Level get(LevelNo levelNo){
   // }
}
