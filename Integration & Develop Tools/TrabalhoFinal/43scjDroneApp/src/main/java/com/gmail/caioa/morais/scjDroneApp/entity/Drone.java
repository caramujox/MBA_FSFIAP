package com.gmail.caioa.morais.scjDroneApp.entity;

import com.gmail.caioa.morais.scjDroneApp.controller.dto.DroneDTO;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


@Data
@ToString
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Drone implements Serializable{
    @Id
    private String idDrone;
    private double latitude;
    private double longitude;
    private double temperatura;
    private double umidade;
    private boolean isRastreamentoAtivo;

    public Drone(DroneDTO droneDTO){
        this.latitude = Double.parseDouble(droneDTO.getLatitude());
        this.longitude = Double.parseDouble(droneDTO.getLongitude());
        this.isRastreamentoAtivo = droneDTO.isRastreamentoAtivo();
    }
}
