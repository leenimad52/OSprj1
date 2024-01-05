package ProcessSimulation;

import ProcessSimulation.scheduling.FCFS;
import ProcessSimulation.scheduling.MultilevelFeedbackQueues;
import ProcessSimulation.scheduling.RR;
import ProcessSimulation.scheduling.SJF;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcessManager {
    private List<Process> readyQueue;
    private List<Double> turnaroundTimes;
    private List<Double> waitingTimes;

    public ProcessManager() {
        readyQueue = new ArrayList<>();
        turnaroundTimes = new ArrayList<>();
        waitingTimes = new ArrayList<>();
    }

    public List<Process> getReadyQueue() {
        return readyQueue;
    }

    public void generateRandomProcesses(int numProcesses) {
        Random random = new Random();
        for (int i = 1; i <= numProcesses; i++) {
            int arrivalTime = random.nextInt(100);
            int burstTime = random.nextInt(96) + 5; // Random burst time between 5 and 100
            readyQueue.add(new Process(i, arrivalTime, burstTime));
        }
    }

    public void runSimulation(String algorithm, int iterations) {
        for (int i = 0; i < iterations; i++) {
//            System.out.println("Algorithm: " + algorithm + " | Iteration " + (i + 1) + ":");

            // Use the selected scheduling algorithm
            switch (algorithm) {
                case "FCFS":
                    FCFS.schedule(new ArrayList<>(readyQueue));
                    break;
                case "SJF":
                    SJF.schedule(new ArrayList<>(readyQueue));
                    break;
                case "RR":
                    RR.schedule(new ArrayList<>(readyQueue), 20); // Use your desired time quantum
                    break;
                case "MultilevelFeedbackQueues":
                    MultilevelFeedbackQueues.schedule(new ArrayList<>(readyQueue));
                    break;
            }

            updateTurnaroundAndWaitingTimes();
            resetProcesses();
        }
    }

    public double getAverageTurnaroundTime() {
        return calculateAverage(turnaroundTimes);
    }

    public double getAverageWaitingTime() {
        return calculateAverage(waitingTimes);
    }

    public void resetProcesses() {
        for (Process process : readyQueue) {
            process.resetBurstTime();
        }
    }

    private void updateTurnaroundAndWaitingTimes() {
        double totalTurnaroundTime = 0;
        double totalWaitingTime = 0;

        for (Process process : readyQueue) {
            totalTurnaroundTime += process.getTurnaroundTime();
            totalWaitingTime += process.getWaitingTime();
        }

        turnaroundTimes.add(totalTurnaroundTime / readyQueue.size());
        waitingTimes.add(totalWaitingTime / readyQueue.size());
    }

    private double calculateAverage(List<Double> values) {
        double total = 0;
        for (Double value : values) {
            total += value;
        }
        return total / values.size();
    }
}
