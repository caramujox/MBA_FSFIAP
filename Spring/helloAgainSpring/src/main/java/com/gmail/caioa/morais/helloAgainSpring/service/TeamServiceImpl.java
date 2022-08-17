package com.gmail.caioa.morais.helloAgainSpring.service;

import com.gmail.caioa.morais.helloAgainSpring.dto.CreateUpdateTeamDTO;
import com.gmail.caioa.morais.helloAgainSpring.dto.TeamDTO;
import com.gmail.caioa.morais.helloAgainSpring.dto.UpdateTeamMembersDTO;
import com.gmail.caioa.morais.helloAgainSpring.service.interfaces.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    List<TeamDTO> list = new ArrayList<>();
    public TeamDTO create(CreateUpdateTeamDTO createUpdateTeamDTO) {
        TeamDTO dto = TeamDTO.builder().id(list.size()+1L)
                .name(createUpdateTeamDTO.getName())
                .supporters(createUpdateTeamDTO.getMembers())
                .foundationDate(createUpdateTeamDTO.getFoundationDate()).build();
               list.add(dto);
               return dto;
    }

    public TeamDTO findById(Long id) {
                return list.stream()
                .filter(teamDTO -> teamDTO.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<TeamDTO> listAll(String name) {
        return list.stream()
                .filter(teamDTO -> name == null || teamDTO.getName().contains(name)).collect(Collectors.toList());
    }

    public TeamDTO updateTeamDTO(Long id, CreateUpdateTeamDTO createUpdateTeamDTO) {
        TeamDTO teamDTO = findById(id);
        teamDTO.setName(createUpdateTeamDTO.getName());
        teamDTO.setFoundationDate(createUpdateTeamDTO.getFoundationDate());
        teamDTO.setSupporters(createUpdateTeamDTO.getMembers());
        return teamDTO;
    }

    public TeamDTO updateMembers(Long id, UpdateTeamMembersDTO updateTeamMembersDTO) {

        TeamDTO teamDTO = findById(id);
        teamDTO.setSupporters(updateTeamMembersDTO.getMembers());
        return teamDTO;
    }

    public void delete(long id) {
        TeamDTO teamDTO = findById(id);
        list.remove(teamDTO);
    }
}
