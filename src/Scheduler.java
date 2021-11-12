import java.util.*;

public class Scheduler { // basic scheduler, aka queue management
     //FIFO ready queue used by both the process creator and CPU
    protected Queue<Process> readyQueue= new LinkedList<Process>();
    protected Queue<Process> waitQueue= new LinkedList<Process>();

    //event
    EventLog event= new EventLog(); //creates events from processes
     //clock: timestamps all events for processes, such as creation time, completion time, etc.
    protected LinkedList<Process> processList = new LinkedList<Process>(); // keep track of all processes
    protected HashMap<Integer,String> clock = new HashMap<Integer,String>();



    protected Process process;

    private int arrivalTime;
    private int burstTime;
    private int completionTime;
    private int turnAroundTime;
    private int waitingTime;
    private int responseTime;
    //increment

    public Scheduler(){}

    public void addQueueNewProcess(Process p){
        this.process = p;
        readyQueue.add(process);
        processList.add(process);
        //event
        event.enumEventToString(Event.CREATE_PROCESS);
        event.createEventDetails("burst", process.getBurstTime());
        event.enumEventToString(Event.SENT_TO_READY_QUEUE);
        event.createEventLog(process.getProcess());
        event.createEventDetails("Arrival Time", process.getArrivalTime());
        event.createEventLog(process.getProcess());
    }



    public void addQueueOldProcess(Process p){
        this.process = p;
        readyQueue.add(process);
        //event
        event.enumEventToString(Event.SENT_TO_READY_QUEUE);
//        event.createEventDetails("burst", process.getBurstTime());
//        event.createEventDetails("Arrival Time", process.getArrivalTime());
        event.createEventLog(process.getProcess());
    }

    public Process getFromQueue(){
        event.enumEventToString(Event.SENT_TO_CPU);
        event.createEventDetails("sent to cpu", process.getBurstTime());
        event.createEventLog(process.getProcess());
        return readyQueue.remove();
    }

    public void contextSwitch(Process out, Process in, int current){
        //terminate old process
        event.enumEventToString(Event.CONTEXT_SWITCH);
        event.createEventDetails("context switch out "+ out.getProcess(), process.getBurstTime());
        //check for remaining burst time
        this.process.setCompletionTime(current);

        //put in new process
        event.createEventDetails("context switch in"+ in.getProcess(), process.getBurstTime());
        event.createEventLog(process.getProcess());
        //send straight to cpu
        waitQueue.remove(in);
    }



    public int nextWaitingTime(int nextProcess){
        waitingTime= this.arrivalTime - nextProcess;
        return waitingTime;
    }
}
