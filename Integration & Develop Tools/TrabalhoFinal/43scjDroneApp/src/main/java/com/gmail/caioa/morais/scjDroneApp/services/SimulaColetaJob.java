package com.gmail.caioa.morais.scjDroneApp.services;

import com.gmail.caioa.morais.scjDroneApp.entity.Drone;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

import java.util.Date;

@Slf4j
public class SimulaColetaJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey jobKey = context.getJobDetail().getKey();
        log.info("##### Iniciando coleta: "+ jobKey + " - " + new Date());
        Drone d = Drone.builder().build();
    }
}
