import java.util.*;

public class Scheduler { // basic scheduler, can be extended to more complicated schedulers
     //FIFO ready queue used by both the process creator and CPU
    protected Queue<Process> readyQueue= new LinkedList<Process>();
    protected Queue<Process> waitQueue= new LinkedList<Process>();

     //clock: timestamps all events for processes, such as creation time, completion time, etc.
    protected LinkedList<Process> processList = new LinkedList<Process>(); // keep track of all processes
    protected HashMap<Integer,String> clock = new HashMap<Integer,String>();

    protected String process;
    protected int idleTime;
    protected int executionTime;

    private int arrivalTime;
    private int burstTime;
    private int completionTime;
    private int turnAroundTime;
    private int waitingTime;
    private int responseTime;
    //increment

    public Scheduler(){}

    public int nextBurst(){
        return this.burstTime--;
    }

    public int nextArrival(){
        return this.arrivalTime++;
    }

    public int nextWaitingTime(int nextProcess){
        //get pointer of next process
        waitingTime= this.arrivalTime - nextProcess;
        return waitingTime;
    }
}
