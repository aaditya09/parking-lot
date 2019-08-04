package com.lld.parkinglot.model;


import com.lld.parkinglot.enums.LevelNo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Level {
    private LevelNo id;
    private Integer maxCapacity;
    private Space[] slots;
    boolean isFull;

    public Level(LevelNo id, Integer maxCapacity, Space[] slots, boolean isFull) {
        this.id = id;
        this.maxCapacity = maxCapacity;
        this.slots = slots;
        this.isFull = isFull;
    }

}
