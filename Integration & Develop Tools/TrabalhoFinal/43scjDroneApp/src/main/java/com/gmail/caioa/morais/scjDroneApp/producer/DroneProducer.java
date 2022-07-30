package com.gmail.caioa.morais.scjDroneApp.producer;

import com.gmail.caioa.morais.scjDroneApp.entity.Drone;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DroneProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage (Drone drone){
        log.info("##### Informações do drone:");
        log.info("### Drone ID: {}", drone.getIdDrone());
        log.info("### Lat/Lon : {}/{}", drone.getLatitude(), drone.getLongitude());
        log.info("### Temperatura : {}", drone.getTemperatura());
        log.info("### % de umidade: {}", drone.getUmidade());
        log.info("### Rastreamento Ativo?: {}", drone.isRastreamentoAtivo());
        log.info("###############");

        kafkaTemplate.send(topicName, drone);
    }
}
