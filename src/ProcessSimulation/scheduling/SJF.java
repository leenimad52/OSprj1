package ProcessSimulation.scheduling;

import ProcessSimulation.Process;

import java.util.Collections;
import java.util.List;

public class SJF {
    public static void schedule(List<Process> processes) {
        Collections.sort(processes, (p1, p2) -> p1.getBurstTime() - p2.getBurstTime());
        runProcesses(processes);
    }

    private static void runProcesses(List<Process> processes) {
        int currentTime = 0;
        for (Process process : processes) {
//            System.out.println("Process " + process.getId() + " starts at time " + currentTime);
            currentTime += process.getBurstTime();
//            System.out.println("Process " + process.getId() + " finishes at time " + currentTime);
        }
    }
}
