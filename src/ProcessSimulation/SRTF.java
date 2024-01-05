package ProcessSimulation;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class SRTF {
    public static void schedule(List<PCB> processes) {
        int currentTime = 0;

        while (!processes.isEmpty()) {
            PCB shortestProcess = findShortestRemainingTime(processes, currentTime);

            if (shortestProcess != null) {
                // Execute the shortest process
                int burstTime = Math.min(shortestProcess.getRemainingBurstTime(), 1); // Execute for 1 unit
                currentTime += burstTime;
                shortestProcess.setRemainingBurstTime(shortestProcess.getRemainingBurstTime() - burstTime);

                if (shortestProcess.getRemainingBurstTime() == 0) {
                    processes.remove(shortestProcess);
                }
            } else {
                currentTime++; // No process to execute, move to the next time unit
            }
        }
    }

    private static PCB findShortestRemainingTime(List<PCB> processes, int currentTime) {
        PCB shortestProcess = null;
        int shortestTime = Integer.MAX_VALUE;

        for (PCB process : processes) {
            if (process.getArrivalTime() <= currentTime && process.getRemainingBurstTime() < shortestTime) {
                shortestProcess = process;
                shortestTime = process.getRemainingBurstTime();
            }
        }

        return shortestProcess;
    }
}
