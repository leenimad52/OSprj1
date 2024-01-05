package ProcessSimulation;

public class Process {
    private int id;
    private int arrivalTime;
    private int burstTime;
    private int originalBurstTime; // Added to store the original burst time
    private int completionTime; // Added to store the completion time

    public Process(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.originalBurstTime = burstTime; // Store the original burst time when the process is created
    }

    public int getId() {
        return id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public void resetBurstTime() {
        this.burstTime = originalBurstTime; // Set burst time back to its original value
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }

    // Additional methods to calculate turnaround and waiting times
    public double getTurnaroundTime() {
        return completionTime - arrivalTime;
    }

    public double getWaitingTime() {
        return getTurnaroundTime() - originalBurstTime;
    }
}
