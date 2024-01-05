package ProcessSimulation;

import java.util.List;
import java.util.ArrayList;

public class Simulation {
    public static void main(String[] args) {
        int[] iterations = { 100, 1000, 10000, 100000 };
        System.out.println("|-----------------|-------------------|-----------------|-----------------|");
        System.out.println("Algorithm\t      | Iterations\t      | ATT\t\t        | AWT");

        for (int iteration : iterations) {
            List<PCB> processes;

            // FCFS
            processes = ProcessGenerator.generateProcesses();
            FCFS.schedule(new ArrayList<>(processes));
            calculateAndPrintMetrics("FCFS   ", processes, iteration);

            // SRTF
            processes = ProcessGenerator.generateProcesses();
            SRTF.schedule(new ArrayList<>(processes));
            calculateAndPrintMetrics("SRTF   ", processes, iteration);

            // RR
            processes = ProcessGenerator.generateProcesses();
            RR.schedule(new ArrayList<>(processes), 20); // Assuming a time quantum of 20 for RR
            calculateAndPrintMetrics("RR    ", processes, iteration);

            // Multilevel Feedback Queues
            processes = ProcessGenerator.generateProcesses();
            MultilevelFeedbackQueues.schedule(new ArrayList<>(processes));
            calculateAndPrintMetrics("MFQ  ", processes, iteration);
        }
    }

    private static void calculateAndPrintMetrics(String algorithm, List<PCB> processes, int iterations) {
        int totalTurnaroundTime = 0;
        int totalWaitingTime = 0;

        for (PCB process : processes) {
            int turnaroundTime = process.getCompletionTime() - process.getArrivalTime();
            int waitingTime = turnaroundTime - process.getBurstTime();
            totalTurnaroundTime += turnaroundTime;
            totalWaitingTime += waitingTime;
        }

        double averageTurnaroundTime = (double) totalTurnaroundTime / processes.size();
        double averageWaitingTime = (double) totalWaitingTime / processes.size();

        // Print table header if it's the first iteration
        if (iterations == 100) {
        }

        // Print results with formatted columns
        System.out.printf("| %-15s | %-17d | %-15.2f | %-15.2f |\n", algorithm, iterations, averageTurnaroundTime, averageWaitingTime);

        // Print lines between rows
        System.out.println("|-----------------|-------------------|-----------------|-----------------|");

        // Print table footer if it's the last iteration
        if (iterations == 100000) {
        }
    }


}
