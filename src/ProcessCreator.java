public class ProcessCreator extends Scheduler {
    //burst
    BurstTime burst= new BurstTime();
    //arrival
    ArrivalTime arrive= new ArrivalTime(-1);


    // time quantum
    int timeQuantum= 1;

    ProcessCreator(String name, int burstTime, int timeQuantum){
        this.timeQuantum= timeQuantum;
        //process
        burst.setBurstTime(burstTime);
        arrive.nextArrival();
        Process process= new Process(name, burst.getBurstTime());
        process.setArrivalTime(arrive.getArrivalTime());
        //call on scheduler to put it in queue
        addQueueNewProcess(process);
        setTimeQuantum(timeQuantum);
    }

    public void newProcess(String name, int burstTime){
//        this.timeQuantum= timeQuantum;
        //process
        burst.setBurstTime(burstTime);
        arrive.nextArrival();
        Process process= new Process(name, burst.getBurstTime());
        process.setArrivalTime(arrive.getArrivalTime());
        //call on scheduler to put it in queue
        addQueueNewProcess(process);
//        setTimeQuantum(timeQuantum);
    }




}
