package com.lld.parkinglot.model;

import com.lld.parkinglot.enums.LevelNo;
import com.lld.parkinglot.enums.Status;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Space {
    private String id;
    private Status status;
    private LevelNo level;
}
