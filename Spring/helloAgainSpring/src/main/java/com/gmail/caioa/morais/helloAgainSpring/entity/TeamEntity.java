package com.gmail.caioa.morais.helloAgainSpring.entity;

import com.gmail.caioa.morais.helloAgainSpring.dto.CreateUpdateTeamDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TB_TEAM")
@Data
@NoArgsConstructor
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate foundationDate;
    private Integer members;

    public  TeamEntity(CreateUpdateTeamDTO createUpdateTeamDTO) {
        this.name = createUpdateTeamDTO.getName();
        this.foundationDate = createUpdateTeamDTO.getFoundationDate();
        this.members = createUpdateTeamDTO.getMembers();
    }
}
