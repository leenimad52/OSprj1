package ProcessSimulation.scheduling;
import java.util.List;
import ProcessSimulation.Process;
import java.util.LinkedList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RR {
    public static void schedule(List<Process> processes, int quantum) {
        Queue<Process> queue = new LinkedList<>(processes);
        while (!queue.isEmpty()) {
            Process process = queue.poll();
            int remainingBurstTime = process.getBurstTime();
//            System.out.println("Process " + process.getId() + " starts at time " + process.getArrivalTime());
            if (remainingBurstTime <= quantum) {
                process.setCompletionTime(process.getArrivalTime() + remainingBurstTime);
//                System.out.println("Process " + process.getId() + " finishes at time " + process.getCompletionTime());
            } else {
                process.setBurstTime(remainingBurstTime - quantum);
                process.setCompletionTime(process.getArrivalTime() + quantum);
//                System.out.println("Process " + process.getId() + " preempts at time " + process.getCompletionTime());
                queue.offer(process);
            }
        }
    }
}
