package com.gmail.caioa.morais.helloAgainSpring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.caioa.morais.helloAgainSpring.dto.CreateUpdateTeamDTO;
import com.gmail.caioa.morais.helloAgainSpring.dto.TeamDTO;
import com.gmail.caioa.morais.helloAgainSpring.dto.UpdateTeamMembersDTO;
import com.gmail.caioa.morais.helloAgainSpring.entity.TeamEntity;
import com.gmail.caioa.morais.helloAgainSpring.repository.TeamRepository;
import com.gmail.caioa.morais.helloAgainSpring.service.interfaces.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;
    private ObjectMapper objectMapper;
    List<TeamDTO> list = new ArrayList<>();
    public TeamDTO create(CreateUpdateTeamDTO createUpdateTeamDTO) {
        TeamEntity teamEntity = new TeamEntity(createUpdateTeamDTO);
        TeamEntity savedTeamEntity = teamRepository.save(teamEntity);
        return new TeamDTO(savedTeamEntity);
    }

    public TeamDTO findById(Long id) {
        TeamEntity teamEntity = teamRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
                return objectMapper.convertValue(teamEntity, TeamDTO.class) ;
    }

    public List<TeamDTO> listAll(String name) {
        List<TeamEntity> list;
        if(name == null) {
            list = teamRepository.findAll();
        }
        else {
            list = teamRepository.findAllByNameContaining(name);
        }
        return list.stream().map(TeamDTO::new).toList();
    }

    public TeamDTO updateTeamDTO(Long id, CreateUpdateTeamDTO createUpdateTeamDTO) {
        TeamEntity entity = teamRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        entity.setName(createUpdateTeamDTO.getName());
        entity.setFoundationDate(createUpdateTeamDTO.getFoundationDate());
        entity.setMembers(createUpdateTeamDTO.getMembers());

        TeamEntity savedEntity = teamRepository.save(entity);
        return new TeamDTO(savedEntity);
    }

    public TeamDTO updateMembers(Long id, UpdateTeamMembersDTO updateTeamMembersDTO) {
        TeamEntity entity = teamRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        entity.setMembers(updateTeamMembersDTO.getMembers());
        TeamEntity savedEntity = teamRepository.save(entity);
        return new TeamDTO(savedEntity);
    }

    public void delete(long id) {
        TeamEntity entity = teamRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        teamRepository.delete(entity);
    }
}
