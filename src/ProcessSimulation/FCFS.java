package ProcessSimulation;

import java.util.List;

public class FCFS {
    public static void schedule(List<PCB> processes) {
        int currentTime = 0;

        for (PCB process : processes) {
            if (process.getArrivalTime() > currentTime) {
                currentTime = process.getArrivalTime();
            }

            // Execute the process
            // Update waiting and turnaround times
            currentTime += process.getBurstTime();
        }
    }
}
