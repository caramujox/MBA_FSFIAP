package com.gmail.caioa.morais.helloAgainSpring.controller;

import com.gmail.caioa.morais.helloAgainSpring.dto.CreateUpdateTeamDTO;
import com.gmail.caioa.morais.helloAgainSpring.dto.TeamDTO;
import com.gmail.caioa.morais.helloAgainSpring.dto.TeamFilterDTO;
import com.gmail.caioa.morais.helloAgainSpring.dto.UpdateTeamMembersDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class TeamController {
   private List<TeamDTO> list = new ArrayList<>();

   public TeamController(){
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
   }
    @GetMapping
    public List<TeamDTO> list (TeamFilterDTO teamFilterDTO) {

        return list.stream().filter(teamDTO -> teamFilterDTO.getName() == null || teamDTO.getName().contains(teamFilterDTO.getName())).toList();
    }

    @GetMapping("{id}")
    public TeamDTO findById(@PathVariable Long id){
        return list.stream()
                .filter(teamDTO -> teamDTO.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDTO create(@RequestBody CreateUpdateTeamDTO createUpdateTeamDTO) {
       TeamDTO dto = TeamDTO.builder().id(list.size()+1L)
                .name(createUpdateTeamDTO.getName())
                .supporters(createUpdateTeamDTO.getMembers())
                .foundationDate(createUpdateTeamDTO.getFoundationDate()).build();

       list.add(dto);
       return dto;
    }

    @PutMapping("{id}")
    public TeamDTO update(@PathVariable Long id,
                          @RequestBody CreateUpdateTeamDTO createUpdateTeamDTO){

       TeamDTO teamDTO = findById(id);
       teamDTO.setName(createUpdateTeamDTO.getName());
       teamDTO.setFoundationDate(createUpdateTeamDTO.getFoundationDate());
       teamDTO.setSupporters(createUpdateTeamDTO.getMembers());

       return teamDTO;
    }

    @PatchMapping("{id}")
    public TeamDTO updateMembers(@PathVariable Long id,
                                 @RequestBody UpdateTeamMembersDTO updateTeamMembersDTO){

       TeamDTO teamDTO = findById(id);
       teamDTO.setSupporters(updateTeamMembersDTO.getMembers());
       return teamDTO;
   }

   @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
       TeamDTO teamDTO = findById(id);

       list.remove(teamDTO);
   }
}
