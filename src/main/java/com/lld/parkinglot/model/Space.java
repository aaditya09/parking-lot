package com.lld.parkinglot.model;

import com.lld.parkinglot.enums.LevelNo;
import com.lld.parkinglot.enums.Status;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Space {
    private String id;
    private Status status;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private LevelNo level;
}
