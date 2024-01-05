package ProcessSimulation.scheduling;
import java.util.Collections;
import java.util.List;
import ProcessSimulation.Process;

public class FCFS {
    public static void schedule(List<Process> processes) {
        Collections.sort(processes, (p1, p2) -> p1.getArrivalTime() - p2.getArrivalTime());
        runProcesses(processes);
    }

    private static void runProcesses(List<Process> processes) {
        int currentTime = 0;
        for (Process process : processes) {
            currentTime = Math.max(currentTime, process.getArrivalTime());
//            System.out.println("Process " + process.getId() + " starts at time " + currentTime);
            currentTime += process.getBurstTime();
//            System.out.println("Process " + process.getId() + " finishes at time " + currentTime);
        }
    }
}
