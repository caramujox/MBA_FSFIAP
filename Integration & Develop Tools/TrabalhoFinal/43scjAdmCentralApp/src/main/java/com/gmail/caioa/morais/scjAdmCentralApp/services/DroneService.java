package com.gmail.caioa.morais.scjAdmCentralApp.services;

import com.gmail.caioa.morais.scjAdmCentralApp.entity.Drone;
import com.gmail.caioa.morais.scjAdmCentralApp.entity.DroneDTO.DroneDTO;
import com.gmail.caioa.morais.scjAdmCentralApp.repository.IDroneRepository;
import com.gmail.caioa.morais.scjAdmCentralApp.services.interfaces.IDroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DroneService implements IDroneService {

    @Autowired
    private IDroneRepository droneRepository;

    public void save(Drone drone){
        droneRepository.save(drone);
    }

    public List<Drone> findAllDrones(){
        return droneRepository.findAll();
    }

    public Drone findDroneById(String id){
        return droneRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    public void moveLocation(Drone drone) {

    }


}
