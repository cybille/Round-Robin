public class CPU {
    protected Process executing;
    protected int timeQuantum;
    protected int idleTime=0;
    protected int executionTime;
    private int completionTime;
    private int turnAroundTime; //cpu arrival- completion
    private int waitingTime;
    private int responseTime;
    private int arrivalTime;
    private float throughput;
    private int cpuArrivalTime;
    private int burstTime;

    // 1- [(contextswitchTime- # of context switches)= idle time/ (total execution) ]= CPU utilization
    ArrivalTime totalTime= new ArrivalTime();
    ArrivalTime contextSwitch= new ArrivalTime();
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
        contextSwitch.incrementArrivalTime();
        //call execute function
    }

//check logic, math checks out
    //do we want to reset cpu arrival time everything
    public void setExecutionTime(){
        this.executionTime= this.executionTime+1;

    }
    public void setIdleTime(int arrivalTime, int waitingTime){
        this.idleTime= arrivalTime + waitingTime;
    }
    public void nextIdleTime(){
        this.idleTime++;
    }

    //set completion time record current time
     //good to go
    public void setCompletionTime(int completionTime, int cpuArrivalTime) {
        this.completionTime= completionTime- cpuArrivalTime;
    }

    //execute
   //check logic, math check out
    //do we want to reset cpu arrive time
    public void setTurnAroundTime(int completionTime){
        this.turnAroundTime= completionTime- 1;

    }
    public void setWaitingTime(int process){
       //arrival time, wait time in queue
        //cpu arrival time is wait for cpu
        this.waitingTime= (arrivalTime + cpuArrivalTime)/process;
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

    public float getThroughput(){
        return throughput;
    }
    public int getWaitingTime(){
        return waitingTime;
    }

    public double getCPUUtilization(){
        int cpuU= 1-((getTurnAroundTime()- contextSwitch.getArrivalTime())/getTotalTime());

        return cpuU;
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
        for (int i= this.timeQuantum; i>0; i--){
            totalTime.incrementArrivalTime();
            this.burstTime--;
            setExecutionTime();
            if (burstTime ==0){
                setCompletionTime(totalTime.getArrivalTime(), cpuArrivalTime);
                setTurnAroundTime(getCompletionTime());
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
        setResponseTime(getIdleTime());
    }

    public void getProcessInfo(){
        System.out.println("execution time " +getExecutionTime());
        System.out.println("Completion time " +getCompletionTime());
        System.out.println("turn around time " +getTurnAroundTime());

    }
    public void getInfo() {
        // CPU Utilization
        //Average Waiting Time= total wait time/ list of processes size
        //Average Turnaround Time= total response time/ list of processes size

        System.out.println("CPU Utilization " +getCPUUtilization());
        System.out.println("Throughput " +getThroughput());
        System.out.println("Average waiting time " +getWaitingTime());
        System.out.println("Average turnAround time " +getTurnAroundTime());
        System.out.println("CPU idle time " +getIdleTime());
    }
}

