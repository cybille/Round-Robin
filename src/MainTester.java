import java.util.HashMap;

public class MainTester {
    public static void main(String[] args) {
        //Testing clock
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
        System.out.println(clockTest.values());



    }
}
