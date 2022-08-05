package com.gmail.caioa.morais.scjDroneApp.services;

import com.gmail.caioa.morais.scjDroneApp.entity.Drone;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DroneService {

    public void moveToPositionMessage(Drone drone) throws InterruptedException {
        log.info("##### Drone indo até ponto de coleta desejado:");
        log.info("### Drone ID: {}", drone.getIdDrone());
        log.info("### Lat/Lon : {}/{}", drone.getLatitude(), drone.getLongitude());
        log.info("### Rastreamento Ativo?: {}", drone.isRastreamentoAtivo());
        log.info("###############");
        Thread.sleep(5000);
        log.info("##### Iniciando coleta: ");
        //TO-DO Quarkz coletar a cada 1s durante 10s
        //TO-DO Envio de msg de alerta
    }
}
