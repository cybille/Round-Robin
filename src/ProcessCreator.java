public class ProcessCreator {
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
        Process process= new Process("name", burst.getBurstTime());
    }

}
