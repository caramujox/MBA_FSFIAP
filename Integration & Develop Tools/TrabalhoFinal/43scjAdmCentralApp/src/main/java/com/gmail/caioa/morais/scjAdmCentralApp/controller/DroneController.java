package com.gmail.caioa.morais.scjAdmCentralApp.controller;

import com.gmail.caioa.morais.scjAdmCentralApp.entity.DroneDTO.DroneCommandDTO;
import com.gmail.caioa.morais.scjAdmCentralApp.entity.DroneDTO.DroneDTO;
import com.gmail.caioa.morais.scjAdmCentralApp.services.DroneService;
import com.gmail.caioa.morais.scjAdmCentralApp.services.interfaces.CommandDroneFeignClient;
import com.gmail.caioa.morais.scjAdmCentralApp.services.interfaces.IDroneService;
import com.gmail.caioa.morais.scjAdmCentralApp.services.mappers.DroneMappers;
import com.gmail.caioa.morais.scjAdmCentralApp.services.mappers.MapStructMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drone")
@AllArgsConstructor
public class DroneController {
    private MapStructMapper mapStructMapper;
    @Autowired
    private IDroneService droneService;

   @Autowired
   private CommandDroneFeignClient commandDroneFeignClient;

   @PostMapping()
    public ResponseEntity<Void> createNewDrone(@RequestBody DroneDTO droneDTO){
       //mapstruct quebrado no IntelliJ? valores falsos ficam como 0 (????)
       //droneService.add(mapStructMapper.droneDTOtoDrone(droneDTO));
       droneService.save(DroneMappers.mapDroneDtoToDrone(droneDTO));
       return new ResponseEntity<>(HttpStatus.CREATED);
   }

   @PostMapping("/{id}/command")
    public ResponseEntity<Void> commandDrone(@PathVariable("id") Integer id, @RequestBody DroneCommandDTO commandDTO){

       commandDroneFeignClient.move(commandDTO);
       //droneService.save(DroneMappers.mapCommandDroneToDrone(commandDTO));
       return new ResponseEntity<>(HttpStatus.ACCEPTED);
   }


}
