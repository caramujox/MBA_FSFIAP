package com.gmail.caioa.morais.helloAgainSpring.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO {

    private Long id;
    private String name;
    private LocalDate foundationDate;
    private Integer supporters;

}
