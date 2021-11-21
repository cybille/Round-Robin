import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProcessCreator processes= new ProcessCreator("p1", 4,2);
        processes.newProcess("p2", 12);
        processes.newProcess("p3", 10);
        System.out.println("waiting time in ready queue " +processes.nextWaitingTime());
        processes.newProcess("p4", 4);
        processes.newProcess("p5", 12);
        System.out.println("\n waiting time in ready queue " + processes.nextWaitingTime());


        ProcessCreator processes2= new ProcessCreator("p6", 12,4);
        processes2.newProcess("p7", 12);

        processes.printClock();
        System.out.println("New processes, new time quantum ");
        processes2.printClock();

        //context switching
        System.out.println("\n Testing context switch with processes 2 ");
        //put in CPU
        processes2.getProcess(processes2.getFromQueue()); //send process to cpu
        //execute
        processes2.executeProcess(); //executed
        processes2.printClock();
        System.out.println(" ");
        //get process from CPU and process from queue
        processes2.contextSwitch(processes2.returnProcess(),processes2.getFromQueue(), processes2.getTurnAroundTime());
        processes2.addQueueOldProcess(processes2.returnProcess());

        processes2.printClock();

        //test interrupt
        System.out.println("\n Testing interrupt with processes");
        processes.printClock();
        processes.getProcess(processes.getFromQueue());
        processes.executeProcess();
        processes.interrupt(processes.returnProcess());

        processes.printClock();
        

    }

}
