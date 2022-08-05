package com.gmail.caioa.morais.scjAdmCentralApp.entity;

import com.gmail.caioa.morais.scjAdmCentralApp.entity.DroneDTO.DroneDTO;
import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EnableAutoConfiguration
@Table(name = "drone", schema = "drone")
public class Drone implements Serializable {
    @Id
    @Column
    private int idDrone;
    @Column
    private double latitude;
    @Column
    private double longitude;
    @Column
    private double temperatura;
    @Column
    private double umidade;
    @Column
    private boolean isRastreamentoAtivo;

}
