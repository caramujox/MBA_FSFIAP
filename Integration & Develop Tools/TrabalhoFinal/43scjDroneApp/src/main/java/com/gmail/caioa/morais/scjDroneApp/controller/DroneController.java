package com.gmail.caioa.morais.scjDroneApp.controller;

import com.gmail.caioa.morais.scjDroneApp.controller.dto.DroneDTO;
import com.gmail.caioa.morais.scjDroneApp.entity.Drone;
import com.gmail.caioa.morais.scjDroneApp.producer.DroneProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/drone")
public class DroneController {

    private final DroneProducer droneProducer;

    @PostMapping(value = "/send")
    public void sendMessage(@RequestBody DroneDTO droneDTO){
        Drone drone = new Drone(droneDTO);
        droneProducer.sendMessage(drone);
    }
}