package com.gmail.caioa.morais.helloAgainSpring.dto;

import com.gmail.caioa.morais.helloAgainSpring.entity.TeamEntity;
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
    private Integer members;

    public TeamDTO(TeamEntity teamEntity) {
        this.id = teamEntity.getId();
        this.name = teamEntity.getName();
        this.foundationDate = teamEntity.getFoundationDate();
        this.members = teamEntity.getMembers();
    }
}
