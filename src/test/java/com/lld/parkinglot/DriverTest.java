package com.lld.parkinglot;

import com.lld.parkinglot.enums.LevelNo;
import com.lld.parkinglot.enums.Type;
import com.lld.parkinglot.model.Bike;
import com.lld.parkinglot.model.Car;
import com.lld.parkinglot.service.ParkingService;
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

        Car car = new Car("AP 26 ST QEN", Type.FOUR_WHEELER);
        Bike bike = new Bike("CG 10  AT KNG", Type.TWO_WHEELER);

        /*Car car = (Car) Car.builder()
                .number("AP 10 SDSD")
                .type(Type.FOUR_WHEELER)
                .build();

        Bike bike = (Bike) Bike.builder()
                .number("CG 10 SDSD")
                .type(Type.TWO_WHEELER)
                .build();
*/
        log.info(parkingService.getAllocatedSpace(LevelNo.BASEMENT).toString());
        log.info(parkingService.getFreeSpace(LevelNo.BASEMENT).toString());
        log.info(parkingService.getFreeSpace(LevelNo.BASEMENT).size() + "");

        log.info(parkingService.getAllocatedSpace(LevelNo.GROUND).toString());
        log.info(parkingService.getFreeSpace(LevelNo.GROUND).toString());
        log.info(parkingService.getFreeSpace(LevelNo.GROUND).size() + "");

        log.info("==========================================================");

        parkingService.park(car, LevelNo.BASEMENT);
        parkingService.park(bike, LevelNo.GROUND);

        log.info("========================PARKING==========================");
        log.info("==========================================================");
        log.info(parkingService.getAllocatedSpace(LevelNo.BASEMENT).toString());
        log.info(parkingService.getFreeSpace(LevelNo.BASEMENT).toString());
        log.info(parkingService.getFreeSpace(LevelNo.BASEMENT).size() + "");

        log.info(parkingService.getAllocatedSpace(LevelNo.GROUND).toString());
        log.info(parkingService.getFreeSpace(LevelNo.GROUND).toString());
        log.info(parkingService.getFreeSpace(LevelNo.GROUND).size() + "");
        log.info("==========================================================");

        log.info(parkingService.getVehicleParkingInfo(bike).toString() );
        log.info(parkingService.getVehicleParkingInfo(car).toString());

       // parkingService.exit(car);

        log.info("==========================================================");
        log.info(parkingService.getAllocatedSpace(LevelNo.BASEMENT).toString());
        log.info(parkingService.getFreeSpace(LevelNo.BASEMENT).toString());
        log.info(parkingService.getFreeSpace(LevelNo.BASEMENT).size() + "");

        log.info(parkingService.getAllocatedSpace(LevelNo.GROUND).toString());
        log.info(parkingService.getFreeSpace(LevelNo.GROUND).toString());
        log.info(parkingService.getFreeSpace(LevelNo.GROUND).size() + "");

        parkingService.payInvoice(car);
        parkingService.exit(car);
    }
}