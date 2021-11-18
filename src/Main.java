import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProcessCreator processes= new ProcessCreator("p1", 4,2);
        Scheduler scheduler= new Scheduler();
        processes.newProcess("p2", 12);
        processes.newProcess("p3", 10);
        System.out.println(processes.nextWaitingTime());
        processes.newProcess("p4", 4);
        processes.newProcess("p5", 12);
        ProcessCreator processes2= new ProcessCreator("p6", 12,4);
        processes2.newProcess("p7", 12);

        System.out.println(processes.getFromQueue()+ " "+ processes.getFromQueue());
        System.out.println(processes.nextWaitingTime());
//        System.out.println();
        processes2.getProcess(processes2.getFromQueue());
        processes.printClock();
        processes2.printClock();
        processes2.executeProcess();
        processes2.contextSwitch(processes2.returnProcess(),processes2.getFromQueue(), processes2.getTurnAroundTime() );
        processes2.addQueueOldProcess(processes2.returnProcess());
        processes2.printClock();




    }

}
