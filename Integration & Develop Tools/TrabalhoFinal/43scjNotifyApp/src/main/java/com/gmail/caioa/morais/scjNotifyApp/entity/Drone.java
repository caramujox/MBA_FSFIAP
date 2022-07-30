package com.gmail.caioa.morais.scjNotifyApp.entity;


import com.gmail.caioa.morais.scjNotifyApp.controller.dto.DroneDTO;
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
    private double umidade;
    private boolean isRastreamentoAtivo;

    public Drone(DroneDTO droneDTO){
        this.idDrone = droneDTO.getIdDrone();
        this.latitude = Double.parseDouble(droneDTO.getLatitude());
        this.longitude = Double.parseDouble(droneDTO.getLongitude());
        this.umidade = Double.parseDouble(droneDTO.getUmidade());
        this.isRastreamentoAtivo = droneDTO.isRastreamentoAtivo();
    }
}
