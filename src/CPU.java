public class CPU {
    protected int timeQuantum;
    protected int idleTime;
    protected int executionTime;
    private int completionTime;
    private int turnAroundTime;
    private int waitingTime;
    private int responseTime;
    //event
    /*Turnaround time: Completion time - Arrival time
    Waiting time: Turnaround time – Burst time
    Response time: the time at which a process gets cpu first time – arrival time
     */

    //execute

    public void setTurnAroundTime(int completionTime, int arrivalTime){
        this.turnAroundTime= completionTime- arrivalTime;
    }
    public void setWaitingTime(int turnAroundTime, int burstTime){
        this.waitingTime= turnAroundTime- burstTime;
    }
    public void setResponseTime(int response ){}




}

