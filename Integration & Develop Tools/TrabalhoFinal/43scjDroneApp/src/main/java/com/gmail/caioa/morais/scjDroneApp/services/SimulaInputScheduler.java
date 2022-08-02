package com.gmail.caioa.morais.scjDroneApp.services;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

@Service
public class SimulaInputScheduler implements Job {

    JobDetail job = JobBuilder.newJob(SimulaInputScheduler.class).withIdentity("job", "grupo").build();
    SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever();

    Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger", "grupo").withSchedule(simpleScheduleBuilder).build();

    Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

    public SimulaInputScheduler() throws SchedulerException {
    }

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            scheduler.scheduleJob(job,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Quartz Job!");
    }
}
