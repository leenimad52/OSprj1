package ProcessSimulation;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] iterations = {100, 1000, 10000, 100000};

        for (String algorithm : getAlgorithms()) {
//            System.out.println("Algorithm: " + algorithm);
            ProcessManager processManager = new ProcessManager();
            processManager.generateRandomProcesses(8);

            for (int iterationCount : iterations) {
//                System.out.println("Number of Iterations: " + iterationCount);
                processManager.runSimulation(algorithm, iterationCount);
                ResultsTable.updateTable(algorithm, processManager.getAverageTurnaroundTime(), processManager.getAverageWaitingTime());
                processManager.resetProcesses();
            }
        }

        ResultsTable.printHeader();
        ResultsTable.printSummaryTable();
        ResultsTable.printAWTTable();
    }

    private static String[] getAlgorithms() {
        // Add or remove algorithms as needed
        return new String[]{"FCFS", "SJF", "RR", "MultilevelFeedbackQueues"};
    }
}
