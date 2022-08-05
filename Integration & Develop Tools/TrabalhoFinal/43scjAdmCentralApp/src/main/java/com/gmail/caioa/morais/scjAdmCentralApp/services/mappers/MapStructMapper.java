package com.gmail.caioa.morais.scjAdmCentralApp.services.mappers;

import com.gmail.caioa.morais.scjAdmCentralApp.entity.Drone;
import com.gmail.caioa.morais.scjAdmCentralApp.entity.DroneDTO.DroneCommandDTO;
import com.gmail.caioa.morais.scjAdmCentralApp.entity.DroneDTO.DroneDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    DroneCommandDTO droneToDroneCommandDTO(Drone drone);

    DroneDTO droneToDroneDTO(Drone drone);

    Drone droneCommandToDrone(DroneCommandDTO droneCommandDTO);

    Drone droneDTOtoDrone(DroneDTO droneDTO);
}
