import java.util.*;

public class Scheduler extends CPU{ // basic scheduler, aka queue management
     //FIFO ready queue used by both the process creator and CPU
    protected Queue<Process> readyQueue= new LinkedList<Process>();
    protected Queue<Process> waitQueue= new LinkedList<Process>();

    //event
    EventLog event= new EventLog(); //creates events from processes
     //clock: timestamps all events for processes, such as creation time, completion time, etc.
    protected LinkedList<Process> processList = new LinkedList<Process>(); // keep track of all processes
    int clockKey=-1;
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
        event.createEventLog(process.getProcess());
        event.enumEventToString(Event.SENT_TO_READY_QUEUE);
        event.createEventDetails("Arrival Time", process.getArrivalTime());
        event.createEventLog(process.getProcess());
        setClock(event.eventLogToString());
    }



    public void addQueueOldProcess(Process p){
        this.process = p;
        readyQueue.add(process);
        //event
        event.enumEventToString(Event.SENT_TO_READY_QUEUE);
//        event.createEventDetails("burst", process.getBurstTime());
//        event.createEventDetails("Arrival Time", process.getArrivalTime());
        event.createEventLog(process.getProcess());
        setClock(event.eventLogToString());
    }

    public Process getFromQueue(){
        event.enumEventToString(Event.SENT_TO_CPU);
        event.createEventDetails("time quantum", process.getBurstTime());
        event.createEventLog(process.getProcess());
        setClock(event.eventLogToString());
        return readyQueue.remove();
    }

    public void contextSwitch(Process out, Process in, int current){
        //terminate old process
        event.enumEventToString(Event.CONTEXT_SWITCH);
        event.createEventDetails("context switch out "+ out.getProcess(), process.getBurstTime());
        setClock(event.eventLogToString());
        //check for remaining burst time
        this.process.setCompletionTime(current);

        //put in new process
        event.createEventDetails("context switch in"+ in.getProcess(), process.getBurstTime());
        event.createEventLog(process.getProcess());
        setClock(event.eventLogToString());
        //send straight to cpu
        waitQueue.remove(in);
    }
    public void interrupt(Process out){
        addQueueOldProcess(out);
        event.enumEventToString(Event.INTERRUPTED);
        event.createEventDetails("time quantum", process.getBurstTime());
        event.createEventLog(process.getProcess());
        setClock(event.eventLogToString());
    }

    public void terminate(Process out){
        event.enumEventToString(Event.TERMINATE_PROCESS);
        event.createEventDetails("time quantum", process.getBurstTime());
        event.createEventLog(process.getProcess());
        setClock(event.eventLogToString());
    }
    public void setClock(String event){
        this.clockKey++;
        clock.put(clockKey,event);
    }

    public void resetClock(){
        this.clockKey=-1;
        clock.clear();
    }

    public void printClock(){
        Set<Map.Entry<Integer,String>> values = clock.entrySet();
        for(Map.Entry<Integer,String> i: values){
            System.out.println(i);
        }
    }
    public int nextWaitingTime(){
        waitingTime= this.arrivalTime - process.getArrivalTime();
        return waitingTime;
    }
}
