package com.ostapenkodmytro.javacore.basepatterns.structural.facade;

public class SprintRunner {
    public static void main(String[] args) {
//        Job job = new Job();
//        job.doJob();
//        BugTracker bugTracker = new BugTracker();
//        bugTracker.startSprint();
//        Developer developer = new Developer();
//        developer.doJobBeforeDeadLine(bugTracker);
//
//        bugTracker.finishSprint();
//        developer.doJobBeforeDeadLine(bugTracker);
        Workflow workflow = new Workflow();
        workflow.solveProblems();
    }
}
