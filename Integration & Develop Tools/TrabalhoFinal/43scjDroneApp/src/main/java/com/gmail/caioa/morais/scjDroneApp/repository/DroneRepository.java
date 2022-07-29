package com.gmail.caioa.morais.scjDroneApp.repository;

import com.gmail.caioa.morais.scjDroneApp.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone,String> {
}
