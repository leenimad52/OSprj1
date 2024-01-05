package ProcessSimulation;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RR {
    public static void schedule(List<PCB> processes, int quantum) {
        Queue<PCB> queue = new LinkedList<>();
        int currentTime = 0;

        while (!processes.isEmpty() || !queue.isEmpty()) {
            // Enqueue processes that have arrived
            while (!processes.isEmpty() && processes.get(0).getArrivalTime() <= currentTime) {
                queue.add(processes.remove(0));
            }

            if (!queue.isEmpty()) {
                PCB process = queue.remove();
                int burstTime = Math.min(quantum, process.getRemainingBurstTime());

                // Execute the process for the current time slice
                currentTime += burstTime;
                process.setRemainingBurstTime(process.getRemainingBurstTime() - burstTime);

                if (process.getRemainingBurstTime() > 0) {
                    queue.add(process);  // Re-queue the process if it's not finished
                } else {
                    // Update completion time for the finished process
                    process.setCompletionTime(currentTime);
                }
            } else {
                currentTime++;
            }
        }
    }
}
