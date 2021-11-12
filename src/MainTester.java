import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainTester {
    public static void main(String[] args) {
        //Testing clock (eventLog class)
        EventLog event= new EventLog(); //creates events from processes
        HashMap<Integer, String> clockTest= new HashMap<>(); //events inserted here
        event.enumEventToString(Event.CREATE_PROCESS);
        event.createEventDetails("burst", 3);
        event.createEventDetails("duration", 2);
        event.createEventDetails("burst", 3);
        event.createEventLog("tester");
//        System.out.println(event.eventLogToString());

        clockTest.put(0,event.eventLogToString());
        event.enumEventToString(Event.INTERRUPTED);
        event.createEventDetails("burst", 5);
        event.createEventDetails("duration", 1);
        event.createEventDetails("switch", 0);
        event.createEventLog("tester");
        clockTest.put(1,event.eventLogToString());
        Set<Map.Entry<Integer,String>> values = clockTest.entrySet();
        for(Map.Entry<Integer,String> i: values){
            System.out.println(i);
        }


 //test process class: process objects where information will be stored
         Process testProcess= new Process("test 1", 2);
         testProcess.setArrivalTime(0);

         Process testProcess2=  new Process("test 2", 4);

         System.out.println("process "+ testProcess.getProcess() + "\n" +
         " burst time "+ testProcess.getBurstTime()+ " other \n ");

         //test timechange class with processes
        //burstTime
        BurstTime burst= new BurstTime();
        burst.setBurstTime(5);
        System.out.println("process "+ testProcess.getProcess() + "\n" +
                " burst time "+ testProcess.getBurstTime()+ " time class \n "+
                testProcess.getBurstTime()+" decrement \n");
        //arrival time
        System.out.println("process "+ testProcess.getProcess() + "\n" +
                " arrival time "+ testProcess.getArrivalTime() + " time class \n "+
                testProcess.getArrivalTime()+" decrement \n");


        //arrival time class
        ArrivalTime arrive= new ArrivalTime();
        arrive.setArrivalTime(0);
        Process processTest3= new Process("3", 4);
        processTest3.setArrivalTime(arrive.getArrivalTime());
        Process processTest4= new Process("4", 5);
        arrive.nextArrival();
        processTest4.setArrivalTime(arrive.getArrivalTime());
        //next arrival
        System.out.println("process "+ processTest3.getProcess() + "\n" +
                " arrival time "+ processTest3.getArrivalTime() + " time class \n "+
                processTest4.getArrivalTime() + " "+ arrive.nextArrival());



    }
}
