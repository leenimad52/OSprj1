package ProcessSimulation;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MultilevelFeedbackQueues {
    public static void schedule(List<PCB> processes) {
        Queue<PCB> queue1 = new LinkedList<>();
        Queue<PCB> queue2 = new LinkedList<>();
        Queue<PCB> queue3 = new LinkedList<>();
        int currentTime = 0;

        while (!processes.isEmpty() || !queue1.isEmpty() || !queue2.isEmpty() || !queue3.isEmpty()) {
            // Enqueue processes that have arrived to the appropriate queue
            while (!processes.isEmpty() && processes.get(0).getArrivalTime() <= currentTime) {
                queue1.add(processes.remove(0));
            }

            // Process at the highest priority (queue1)
            if (!queue1.isEmpty()) {
                PCB process = queue1.remove();
                int burstTime = Math.min(process.getRemainingBurstTime(), 1); // Execute for 1 unit
                currentTime += burstTime;
                process.setRemainingBurstTime(process.getRemainingBurstTime() - burstTime);

                if (process.getRemainingBurstTime() > 0) {
                    queue2.add(process); // Move to the next priority queue
                }
            } else if (!queue2.isEmpty()) {
                // Process at the second priority (queue2)
                PCB process = queue2.remove();
                int burstTime = Math.min(process.getRemainingBurstTime(), 2); // Execute for 2 units
                currentTime += burstTime;
                process.setRemainingBurstTime(process.getRemainingBurstTime() - burstTime);

                if (process.getRemainingBurstTime() > 0) {
                    queue3.add(process); // Move to the next priority queue
                }
            } else if (!queue3.isEmpty()) {
                // Process at the lowest priority (queue3)
                PCB process = queue3.remove();
                int burstTime = Math.min(process.getRemainingBurstTime(), 4); // Execute for 4 units
                currentTime += burstTime;
                process.setRemainingBurstTime(process.getRemainingBurstTime() - burstTime);

                if (process.getRemainingBurstTime() > 0) {
                    queue3.add(process); // Remain in the same priority queue
                }
            } else {
                currentTime++; // No process to execute, move to the next time unit
            }
        }
    }
}
