package ProcessSimulation.scheduling;
import java.util.List;
import ProcessSimulation.Process;
import java.util.LinkedList;
import java.util.Queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MultilevelFeedbackQueues {
    public static void schedule(List<Process> processes) {
        Queue<Process> q1 = new LinkedList<>();
        Queue<Process> q2 = new LinkedList<>();
        Queue<Process> q3 = new LinkedList<>();

        for (Process process : processes) {
            if (process.getBurstTime() <= 10) {
                q1.offer(process);
            } else if (process.getBurstTime() <= 50) {
                q2.offer(process);
            } else {
                q3.offer(process);
            }
        }

        RR.schedule(new LinkedList<>(q1), 10);
        RR.schedule(new LinkedList<>(q2), 50);
        FCFS.schedule(new LinkedList<>(q3));
    }
}

