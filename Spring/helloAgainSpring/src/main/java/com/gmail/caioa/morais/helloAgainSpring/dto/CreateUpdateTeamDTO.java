package com.gmail.caioa.morais.helloAgainSpring.dto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
@Builder
public class CreateUpdateTeamDTO {
    private String name;
    private LocalDate foundationDate;
    private Integer members;
}
