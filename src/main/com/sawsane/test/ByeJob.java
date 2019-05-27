package com.sawsane.test;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ByeJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Byyyee");
    }
}
