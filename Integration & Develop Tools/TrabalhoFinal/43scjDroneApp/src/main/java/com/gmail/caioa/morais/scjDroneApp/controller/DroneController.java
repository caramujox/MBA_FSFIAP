package com.gmail.caioa.morais.scjDroneApp.controller;

import com.gmail.caioa.morais.scjDroneApp.controller.dto.DroneDTO;
import com.gmail.caioa.morais.scjDroneApp.entity.Drone;
import com.gmail.caioa.morais.scjDroneApp.producer.DroneProducer;
import com.gmail.caioa.morais.scjDroneApp.services.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/drone")
public class DroneController {

    private final DroneProducer droneProducer;

    @Autowired
    private DroneService service;

    @PostMapping(value = "/send")
    public void sendMessage(@RequestBody DroneDTO droneDTO){
        Drone drone = new Drone(droneDTO);
        droneProducer.sendMessage(drone);
    }

    @PostMapping(value ="/move")
    public void moveDroneToPosition(@RequestBody DroneDTO droneDTO) throws InterruptedException {
        Drone drone = new Drone(droneDTO);
        service.moveToPositionMessage(drone);
    }

}