package com.gmail.caioa.morais.helloAgainSpring.controller;

import com.gmail.caioa.morais.helloAgainSpring.dto.TeamDTO;
import com.gmail.caioa.morais.helloAgainSpring.dto.TeamFilterDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class TeamController {

    @GetMapping
    public List<TeamDTO> list (TeamFilterDTO teamFilterDTO) {
        List<TeamDTO> list = new ArrayList<>();
        list.add(TeamDTO.builder().id(1L).
                foundationDate(LocalDate.of(1910, 01, 01))
                .name("Corinthians")
                .supporters(10000)
                .build());

        list.add(TeamDTO.builder().id(2L)
                .foundationDate(LocalDate.of(1910, 01, 01))
                .name("Flamengo")
                .supporters(200000)
                .build()
        );
        return list.stream().filter(teamDTO -> teamFilterDTO.getName() == null || teamDTO.getName().contains(teamFilterDTO.getName())).toList();
    }
}
