package com.gmail.caioa.morais.helloAgainSpring.controller;

import com.gmail.caioa.morais.helloAgainSpring.dto.CreateUpdateTeamDTO;
import com.gmail.caioa.morais.helloAgainSpring.dto.TeamDTO;
import com.gmail.caioa.morais.helloAgainSpring.dto.TeamFilterDTO;
import com.gmail.caioa.morais.helloAgainSpring.dto.UpdateTeamMembersDTO;
import com.gmail.caioa.morais.helloAgainSpring.service.TeamServiceImpl;
import com.gmail.caioa.morais.helloAgainSpring.service.interfaces.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TeamController {

    private TeamService teamService;

   public TeamController(TeamServiceImpl teamService){
       this.teamService = teamService;
   }

    @GetMapping
    public List<TeamDTO> list (TeamFilterDTO teamFilterDTO) {

       return teamService.listAll(teamFilterDTO.getName());
    }

    @GetMapping("{id}")
    public TeamDTO findById(@PathVariable Long id){
       return teamService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDTO create(@RequestBody CreateUpdateTeamDTO createUpdateTeamDTO) {
       return teamService.create(createUpdateTeamDTO);
    }

    @PutMapping("{id}")
    public TeamDTO update(@PathVariable Long id,
                          @RequestBody CreateUpdateTeamDTO createUpdateTeamDTO){
       return teamService.updateTeamDTO(id, createUpdateTeamDTO);
    }

    @PatchMapping("{id}")
    public TeamDTO updateMembers(@PathVariable Long id,
                                 @RequestBody UpdateTeamMembersDTO updateTeamMembersDTO){

       return teamService.updateMembers(id, updateTeamMembersDTO);
   }

   @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
       teamService.delete(id);

   }
}
