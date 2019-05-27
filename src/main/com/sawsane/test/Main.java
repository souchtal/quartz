package com.sawsane.test;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            JobDetail job1 = JobBuilder.newJob(HelloJob.class).withIdentity("helloJob", "group1").build();

            Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "group1")
                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(30)).build();
            Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
            scheduler1.start();
            scheduler1.scheduleJob(job1, trigger1);

            JobDetail job2 = JobBuilder.newJob(ByeJob.class).withIdentity("byeJob", "group2").build();
            Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("cronTrigger", "group2")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
            Scheduler scheduler2 = new StdSchedulerFactory().getScheduler();
            scheduler2.start();
            scheduler2.scheduleJob(job2, trigger2);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
