package ProcessSimulation;

import java.util.List;

public class FCFS {
    public static void schedule(List<PCB> processes) {
        int currentTime = 0;

        for (PCB process : processes) {
            if (process.getArrivalTime() > currentTime) {
                currentTime = process.getArrivalTime();
            }

            // Update the completion time for each process
            process.setCompletionTime(currentTime + process.getBurstTime());

            currentTime += process.getBurstTime();
        }
    }
}
