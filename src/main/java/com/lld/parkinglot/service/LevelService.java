package com.lld.parkinglot.service;

import com.lld.parkinglot.enums.LevelNo;
import com.lld.parkinglot.enums.Status;
import com.lld.parkinglot.model.Space;
import com.lld.parkinglot.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Aaditya.t on 7/8/19.
 */

@Service
public class LevelService {

    private LevelRepository levelRepository;


    @Autowired
    public LevelService(LevelRepository levelRepository){
        this.levelRepository = levelRepository;
    }


    void create(LevelNo level, Integer maxCapacity){
        levelRepository.insert(level, maxCapacity);
    }

    List<Space> find(LevelNo level) {
        return levelRepository.get(level);
    }

    List<Space> find(LevelNo level, Status status) {
        return levelRepository.getByStatusAndLevel(level, status);
    }
}
