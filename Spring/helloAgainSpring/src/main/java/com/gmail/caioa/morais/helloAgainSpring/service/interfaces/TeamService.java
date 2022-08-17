package com.gmail.caioa.morais.helloAgainSpring.service.interfaces;

import com.gmail.caioa.morais.helloAgainSpring.dto.CreateUpdateTeamDTO;
import com.gmail.caioa.morais.helloAgainSpring.dto.TeamDTO;
import com.gmail.caioa.morais.helloAgainSpring.dto.UpdateTeamMembersDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TeamService {
    TeamDTO create(CreateUpdateTeamDTO createUpdateTeamDTO);

    TeamDTO findById(Long id);
    List<TeamDTO> listAll(String name);

    TeamDTO updateTeamDTO(Long id, CreateUpdateTeamDTO createUpdateTeamDTO);

    TeamDTO updateMembers(Long id, UpdateTeamMembersDTO updateTeamMembersDTO);

    void delete (long id);
}
