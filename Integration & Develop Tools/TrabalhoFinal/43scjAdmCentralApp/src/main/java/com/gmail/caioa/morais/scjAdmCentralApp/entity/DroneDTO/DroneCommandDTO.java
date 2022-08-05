package com.gmail.caioa.morais.scjAdmCentralApp.entity.DroneDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DroneCommandDTO {

    @JsonProperty("latitude")
    private String latitude;

    @JsonProperty("longitude")
    private String longitude;

    @JsonProperty("rastreamento_ativo")
    private boolean isRastreamentoAtivo;
}
