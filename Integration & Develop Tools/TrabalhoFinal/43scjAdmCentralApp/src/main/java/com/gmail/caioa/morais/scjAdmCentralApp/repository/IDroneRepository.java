package com.gmail.caioa.morais.scjAdmCentralApp.repository;

import com.gmail.caioa.morais.scjAdmCentralApp.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDroneRepository extends JpaRepository<Drone,String> {
}
