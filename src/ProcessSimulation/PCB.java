package ProcessSimulation;


public class PCB { // Process Control Block
    private int processID;
    private int arrivalTime;
    private int burstTime;
    private int remainingBurstTime;
    private int completionTime; // New field to track completion time

    public PCB(int processID, int arrivalTime, int burstTime) {
        this.processID = processID;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingBurstTime = burstTime;
        this.completionTime = -1; // Initialize completion time to -1 (indicating not completed)
    }

    // Getters and setters

    public int getProcessID() {
        return processID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getRemainingBurstTime() {
        return remainingBurstTime;
    }

    public void setRemainingBurstTime(int remainingBurstTime) {
        this.remainingBurstTime = remainingBurstTime;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }
}
