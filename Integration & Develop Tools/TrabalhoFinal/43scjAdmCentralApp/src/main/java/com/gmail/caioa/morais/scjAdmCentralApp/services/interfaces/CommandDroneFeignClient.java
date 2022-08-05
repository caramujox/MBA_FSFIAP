package com.gmail.caioa.morais.scjAdmCentralApp.services.interfaces;

import com.gmail.caioa.morais.scjAdmCentralApp.entity.DroneDTO.DroneCommandDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="producer-drone", url = "${command.drone.app}")
public interface CommandDroneFeignClient {

    @PostMapping(value = "/move", consumes = "application/json")
    void move(DroneCommandDTO commandDTO);
}
