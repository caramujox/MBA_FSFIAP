package com.gmail.caioa.morais.helloAgainSpring.repository;


import com.gmail.caioa.morais.helloAgainSpring.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {

    public List<TeamEntity> findAllByNameContaining(String name);

}
