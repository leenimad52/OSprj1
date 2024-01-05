package ProcessSimulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ProcessGenerator {
    public static List<PCB> generateProcesses() {
        List<PCB> processes = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            PCB process = new PCB(i, i * 5, random.nextInt(96) + 5);
            processes.add(process);
        }

        // Sort processes by arrival time
        processes.sort(Comparator.comparingInt(PCB::getArrivalTime));

        return processes;
    }
}
