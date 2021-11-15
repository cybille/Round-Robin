public class CPU {
    protected int timeQuantum;
    protected int idleTime;
    protected int executionTime;
    private int completionTime;
    private int turnAroundTime;
    private int waitingTime;
    private int responseTime;
    private int arrivalTime;
    private int cpuArrivalTime;
    private int burstTime;

    ArrivalTime totalTime= new ArrivalTime();
    /*Turnaround time: Completion time - Arrival time
    Waiting time: Turnaround time – Burst time
    Response time: the time at which a process gets cpu first time – arrival time
     */

    //execute

    public void setTurnAroundTime(int completionTime, int cpuArrivalTime){
        this.turnAroundTime= completionTime- cpuArrivalTime;
    }
    public void setWaitingTime(int turnAroundTime, int burstTime){

        this.waitingTime= turnAroundTime- burstTime;
    }
    public void setResponseTime(int idleTime, int cpuArrivalTime){
        this.responseTime= idleTime- cpuArrivalTime;
    }




}

