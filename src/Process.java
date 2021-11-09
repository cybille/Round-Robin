
public class Process {
    String processName;
    protected int pointer = 0;

    protected int idleTime;
    protected int executionTime;

    //times
    private int arrivalTime = 0;
    private int burstTime = 1;
    BurstTime burst = new BurstTime();
    private int completionTime = 0;
    private int turnAroundTime = 0;
    private int waitingTime = 0;
    private int responseTime = 0;


    public Process(String name, int burstTime){
        this.burst.setBurstTime(burstTime);
        this.processName = name;
        this.burstTime= burst.getBurstTime();

    }

    public String getProcess(){
        return this.processName;
    }
    //setters
    public void setArrivalTime(int time){
        this.arrivalTime = time;
    }
    public void setBurstTime(int time){
        this.burstTime = time;
    }
    public void setCompletionTime(int time){
        this.completionTime = time;
    }
    public void setTurnAroundTime(int time){
        this.turnAroundTime = time;
    }
    public void setWaitingTime(int time){
        this.waitingTime = time;
    }
    public void setResponseTime(int time){
        this.responseTime = time;
    }
    public void setIdleTime(int time){
        this.idleTime = time;
    }
    public void setExecutionTime(int time){
        this.executionTime = time;
    }

    // getters
    public int getArrivalTime(){
        return this.arrivalTime;
    }
    public int getBurstTime(){
        return this.burstTime;
    }
    public int getCompletionTime(){
        return this.completionTime;
    }
    public int getTurnAroundTime(){
        return this.turnAroundTime;
    }
    public int getWaitingTime(){
        return this.waitingTime;
    }
    public int getResponseTime(){
        return this.responseTime;
    }
    public int getIdleTime(){
        return this.idleTime;
    }
    public int getExecutionTime(){
        return this.executionTime;
    }



}
