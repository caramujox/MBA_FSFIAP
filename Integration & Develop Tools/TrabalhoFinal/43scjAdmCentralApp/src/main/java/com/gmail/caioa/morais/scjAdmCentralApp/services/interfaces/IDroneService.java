package com.gmail.caioa.morais.scjAdmCentralApp.services.interfaces;

import com.gmail.caioa.morais.scjAdmCentralApp.entity.Drone;

import java.util.List;

public interface IDroneService {
    // Register new Drone
    public void save (Drone drone);

    public List<Drone> findAllDrones();

    public Drone findDroneById(String id);

    //Command Drone
    public void moveLocation(Drone drone);

}
