package com.gmail.caioa.morais.helloAgainSpring.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdateTeamDTO {
    private String name;
    private LocalDate foundationDate;
    private Integer members;
}
