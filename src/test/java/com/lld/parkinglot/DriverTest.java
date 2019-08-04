package com.lld.parkinglot;

import com.lld.parkinglot.enums.LevelNo;
import com.lld.parkinglot.service.ParkingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes={ParkingLotApp.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DriverTest {

    @Autowired
    private ParkingService parkingService;

    @Test
    public void testParkingLot() {
        parkingService.initializeLevel(10, LevelNo.BASEMENT);
        System.out.println(parkingService.getLevels().toString());

    }
}