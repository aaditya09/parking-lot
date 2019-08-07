package com.lld.parkinglot.repository;

import com.lld.parkinglot.enums.LevelNo;
import com.lld.parkinglot.enums.Status;
import com.lld.parkinglot.exception.FailedToInitializeLevelException;
import com.lld.parkinglot.model.Space;
import org.springframework.stereotype.Repository;

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
        ArrayList<Space> spaces = new ArrayList<>();
        AtomicInteger initialSpaceId = new AtomicInteger(65);

        try {
            IntStream.range(1, maxCapacity).forEach(num -> {
                spaces.add(
                        Space.builder()
                                .level(level)
                                .id((char) initialSpaceId.getAndIncrement() + "-" + num)
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

    public List<Space> getByStatusAndLevel(LevelNo level, Status status) {
        List<Space> levelSpaces = spaceMap.get(level);
        return levelSpaces.stream().filter(space -> space.getStatus().equals(status)).collect(Collectors.toList());
    }
}
