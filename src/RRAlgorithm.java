import java.util.Queue;

public class RRAlgorithm extends Scheduler {
    //code plan
    /*
     // create processes hard code
     //algorithm for RR (psudeo)
     do{
     getfromqueue // scheduler class takes process out
     getprocess //cpu class takes in process
     executeAll // cpu class executes process
     (event: process is executed)
        - check burt time
        if bursttime == 0
         contextSwitch(returnProcess, getFromQueue, getTurnAroundTime())
         terminate(process): process is completed
        //get completion time
        else
        send back to queue :
         - CPU class, returns process and new info
           contextSwitch(returnProcess, getFromQueue, getTurnAroundTime())
           addQueueOldProcess- scheduler class, add process to back of queue
} while(queue!=empty)
     */
    public RRAlgorithm(){
        super();
    }
    public void rR(ProcessCreator pc){
        this.readyQueue= pc.readyQueue;
        try {
            do {
                System.out.println(readyQueue.size());
                Process p = pc.getFromQueue();
                pc.getProcess(p);
                pc.executeAll();
                pc.event.enumEventToString(Event.EXECUTE_PROCESS);
                pc.event.createEventDetails("CPU Arrival Time", getCpuArrivalTime());
                pc.event.createEventLog(p.getProcess());
                pc.setClock(pc.event.eventLogToString());

                if (pc.burstTime()) {
                    pc.contextSwitch(pc.returnProcess(), pc.getFromQueue(), getTurnAroundTime());
                    pc.terminate(p);
                } else {
                    Process outP = pc.returnProcess();
                    pc.contextSwitch(outP, pc.getFromQueue(), pc.getTurnAroundTime());
                    pc.addQueueOldProcess(outP);
                }
            } while (!readyQueue.isEmpty());
        } catch(Exception e){
            System.out.println("end of processes");
        }


    }
}
