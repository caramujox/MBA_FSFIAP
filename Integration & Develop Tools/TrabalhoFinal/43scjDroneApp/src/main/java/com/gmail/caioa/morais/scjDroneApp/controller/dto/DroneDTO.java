package com.gmail.caioa.morais.scjDroneApp.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class DroneDTO {
    @JsonProperty("id_drone")
    private String idDrone;

    @JsonProperty("latitude")
    private String latitude;

    @JsonProperty("longitude")
    private String longitude;

    @JsonProperty("umidade")
    private String umidade;

    @JsonProperty("rastreamento_ativo")
    private boolean isRastreamentoAtivo;

}
