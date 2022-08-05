package com.gmail.caioa.morais.scjAdmCentralApp.services.mappers;

import com.gmail.caioa.morais.scjAdmCentralApp.entity.Drone;
import com.gmail.caioa.morais.scjAdmCentralApp.entity.DroneDTO.DroneCommandDTO;
import com.gmail.caioa.morais.scjAdmCentralApp.entity.DroneDTO.DroneDTO;

//Classe criada por conta dos problemas que estou enfrentando com o MapStruct
public class DroneMappers {

    public static Drone mapDroneDtoToDrone(DroneDTO droneDTO) {
        return Drone.builder()
                .idDrone((Integer.parseInt(droneDTO.getIdDrone())))
                .isRastreamentoAtivo(droneDTO.isRastreamentoAtivo())
                .build();
    }

    public static DroneDTO mapDroneToDroneDTO(Drone drone){
        return DroneDTO.builder()
                .idDrone(String.valueOf(drone.getIdDrone()))
                .isRastreamentoAtivo(drone.isRastreamentoAtivo())
                .build();
    }

    public static Drone mapCommandDroneToDrone(DroneCommandDTO droneCommandDTO){
        return Drone.builder()
                .isRastreamentoAtivo(droneCommandDTO.isRastreamentoAtivo())
                .latitude(Double.parseDouble(droneCommandDTO.getLatitude()))
                .longitude(Double.parseDouble(droneCommandDTO.getLongitude()))
                .build();
    }

    public static DroneCommandDTO mapDroneToCommandDrone(Drone drone){
        return DroneCommandDTO.builder()
                .latitude(String.valueOf(drone.getLatitude()))
                .longitude(String.valueOf(drone.getLongitude()))
                .isRastreamentoAtivo(drone.isRastreamentoAtivo())
                .build();
    }
}
