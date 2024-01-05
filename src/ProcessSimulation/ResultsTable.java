package ProcessSimulation;
import java.util.HashMap;
import java.util.Map;

public class ResultsTable {
    private static Map<String, Map<Integer, Double>> attTable = new HashMap<>();
    private static Map<String, Map<Integer, Double>> awtTable = new HashMap<>();

    public static void printHeader() {
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-20s | %-12s | %-12s | %-12s | %-12s%n", "Algorithm", "ATT (100)", "ATT (1000)", "ATT (10000)", "ATT (100000)");
        System.out.println("---------------------------------------------------------");
    }

    public static void updateTable(String algorithm, double att, double awt) {
        attTable.computeIfAbsent(algorithm, k -> new HashMap<>()).put(attTable.get(algorithm).size() + 1, att);
        awtTable.computeIfAbsent(algorithm, k -> new HashMap<>()).put(awtTable.get(algorithm).size() + 1, awt);
    }

    public static void printSummaryTable() {
        String[] algorithms = {"FCFS", "SJF", "RR", "MultilevelFeedbackQueues"};

        for (String algorithm : algorithms) {
            System.out.printf("%-20s |", algorithm);
            Map<Integer, Double> attValues = attTable.get(algorithm);
            Map<Integer, Double> awtValues = awtTable.get(algorithm);

            for (int iterationCount : attValues.keySet()) {
                System.out.printf(" %-12.2f |", attValues.get(iterationCount));
            }
            System.out.println("\n------------------------------------------------------------------------------------------------------------------");

            System.out.printf("%-20s |", "");
            for (int iterationCount : awtValues.keySet()) {
                System.out.printf(" %-12.2f |", awtValues.get(iterationCount));
            }
            System.out.println("\n------------------------------------------------------------------------------------------------------------------");
        }
    }
    public static void printAWTTable() {
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s | %-12s | %-12s | %-12s | %-12s%n", "Algorithm", "AWT (100)", "AWT (1000)", "AWT (10000)", "AWT (100000)");
        System.out.println("------------------------------------------------------------------------------------------------------------------");

        for (String algorithm : attTable.keySet()) {
            Map<Integer, Double> awtValues = awtTable.get(algorithm);
            System.out.printf("%-20s |", algorithm);

            for (int iterationCount : awtValues.keySet()) {
                System.out.printf(" %-12.2f |", awtValues.get(iterationCount));
            }
            System.out.println("\n------------------------------------------------------------------------------------------------------------------");
        }
    }
}

