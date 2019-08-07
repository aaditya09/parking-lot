package com.lld.parkinglot;

import com.lld.parkinglot.enums.LevelNo;
import com.lld.parkinglot.enums.Type;
import com.lld.parkinglot.model.Car;
import com.lld.parkinglot.model.Level;
import com.lld.parkinglot.model.Vehicle;
import com.lld.parkinglot.repository.ParkingRepository;
import com.lld.parkinglot.service.ParkingService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@SpringBootTest(classes={ParkingLotApp.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DriverTest {

    @Autowired
    private ParkingService parkingService;

    @Test
    public void testParkingLot() {
        parkingService.initializeLevel(10, LevelNo.BASEMENT);

        parkingService.initializeLevel(7, LevelNo.GROUND);

        parkingService.initializeLevel(6, LevelNo.ONE);

        // Car car = (Car) Car.builder()
         //       .number("KA 10 ABDC")
          //      .type(Type.FOUR_WHEELER)
           //     .build();


        log.info(parkingService.getAllSpace(LevelNo.BASEMENT).toString());
        log.info(parkingService.getFreeSpace(LevelNo.BASEMENT).toString());
        log.info(parkingService.getAllocatedSpace(LevelNo.BASEMENT).toString());
    }
}