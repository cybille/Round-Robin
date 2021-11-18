public class CPU {
    protected Process executing;
    protected int timeQuantum;
    protected int idleTime;
    protected int executionTime;
    private int completionTime;
    private int turnAroundTime; //cpu arrival- completion
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

    public CPU(){
    }

    //set time quantum
    public void setTimeQuantum(int time){
        this.timeQuantum= time;
    }
    //receive new process record arrival
    public void getProcess(Process process){
        this.executing= process;
        this.arrivalTime=process.getArrivalTime();
        this.burstTime= process.getBurstTime();
        this.cpuArrivalTime= totalTime.getArrivalTime();
//        totalTime.incrementArrivalTime();
        System.out.println("CPU Arrival Time: "+ cpuArrivalTime);
        //call execute function
    }

//check logic, math checks out
    //do we want to reset cpu arrival time everything
    public void setExecutionTime(int burstTime, int cpuArrivalTime){
        this.executionTime= (burstTime - 1);
        System.out.println("Execute Time Total "+ getExecutionTime());


    }
    public void setIdleTime(int arrivalTime, int waitingTime){
        this.idleTime= arrivalTime + waitingTime;
    }

    //set completion time record current time
     //good to go
    public void setCompletionTime(int completionTime, int cpuArrivalTime) {
        System.out.println("Total " +completionTime+ " CPU "+ cpuArrivalTime);
        this.completionTime= completionTime- cpuArrivalTime;
        System.out.println("Completion Time Total "+ getCompletionTime());
    }

    //execute
   //check logic, math check out
    //do we want to reset cpu arrive time
    public void setTurnAroundTime(int completionTime, int cpuArrivalTime){
        this.turnAroundTime= completionTime- 1;
        System.out.println("Turn Time Total "+ getTurnAroundTime());

    }
    public void setWaitingTime(int turnAroundTime, int burstTime){
        this.waitingTime= turnAroundTime- burstTime;
    }
    public void setResponseTime(int idleTime, int cpuArrivalTime){
        this.responseTime= idleTime- cpuArrivalTime;
    }

    //

    public int getCompletionTime() {
        return completionTime;
    }

    public int getCpuArrivalTime() {
        return cpuArrivalTime;
    }

    public int getTotalTime() {
        return totalTime.getArrivalTime();
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public int getIdleTime() {
        return idleTime;
    }

    public Process returnProcess(){
        return executing;
    }

    //execute process
    //loop, decrement burstime - timequantum
    //increment arrival or time in the cpu (total time)
    //if burst time = 0
    // use set completion time to get current time: time done- time arrived
    //set turnaround
    public void executeProcess(){
        setExecutionTime(burstTime,cpuArrivalTime);
        for (int i= this.timeQuantum; i>0; i--){
            totalTime.incrementArrivalTime();
            this.burstTime--;
            if (burstTime ==0){
                setCompletionTime(totalTime.getArrivalTime(), cpuArrivalTime);
                setTurnAroundTime(getCompletionTime(), cpuArrivalTime);
                break;
            }
            //potential cpu arrive time reset
        }
        executing.setBurstTime(burstTime);
    }
    //boolean checker
    public boolean burstTime(){
        if (burstTime == 0){
            return true; //process done
        }
        else
            return false; //process not done, send back to queue
    }

    public void executeAll(){
        executeProcess();
        setWaitingTime(getTurnAroundTime(), burstTime);
        setResponseTime(getIdleTime(),cpuArrivalTime);
    }





}

