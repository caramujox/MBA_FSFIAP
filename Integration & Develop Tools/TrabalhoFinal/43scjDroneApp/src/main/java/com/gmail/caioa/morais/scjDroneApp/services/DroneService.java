package com.gmail.caioa.morais.scjDroneApp.services;

import com.gmail.caioa.morais.scjDroneApp.entity.Drone;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DroneService {

    SchedulerFactory sf = new StdSchedulerFactory();
    Scheduler sched = sf.getScheduler();

    JobDetail job = JobBuilder.newJob(SimulaColetaJob.class)
            .withIdentity("coletaDados", "group1")
            .build();

    CronTrigger trigger = TriggerBuilder.newTrigger()
            .withIdentity("triggerColeta", "group1")
            .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?"))
            .build();

    public DroneService() throws SchedulerException {
    }

    public void moveToPositionMessage(Drone drone) throws InterruptedException, SchedulerException {
        log.info("##### Drone indo até ponto de coleta desejado:");
        log.info("### Drone ID: {}", drone.getIdDrone());
        log.info("### Lat/Lon : {}/{}", drone.getLatitude(), drone.getLongitude());
        log.info("### Rastreamento Ativo?: {}", drone.isRastreamentoAtivo());
        log.info("###############");
        sched.scheduleJob(job, trigger);
        sched.start();
        Thread.sleep(90L * 1000L);

        //TO-DO Quarkz coletar a cada 1s durante 10s
        //TO-DO Envio de msg de alerta
    }
}
