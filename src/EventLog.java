import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class EventLog {
    protected String eventKeywordS;
    protected Event eventKeywordE;
    protected String stringLog;
    protected Event enumLog;
    protected EventLog eventLog;
    protected String timeStamp;
    protected String detail;
    protected String process;
    protected ArrayList<String> arrayList= new ArrayList<String>();

    // for returning in object only
    private String currentTime;
    private String event;
    private String processName;
    private String details;



    public EventLog(){
    }
    public EventLog(String timeStamp, String event, String processName, String details){
        this.currentTime = timeStamp;
        this.event= event;
        this.processName= processName;
        this.details= details;
    }

    public void enumEventToString(Event event){ //input = Event.CREATE_PROCESS
        createTimestamp(); //create log of current date and time when function is used
        this.eventKeywordE= event;
        switch (event){
            case CREATE_PROCESS:
                this.stringLog= "Created process";
                break;
            case EXECUTE_PROCESS:
                this.stringLog= "Execute process";
                break;
            case TERMINATE_PROCESS:
                this.stringLog= "Terminate process";
                break;
            case SENT_TO_READY_QUEUE:
                this.stringLog= "Sent to ready queue:";
                break;
            case SENT_TO_WAIT_QUEUE:
                this.stringLog= "Sent to wait queue:";
                break;
            case SENT_TO_CPU:
                this.stringLog= "Sent to CPU:";
                break;
            case INTERRUPTED:
                this.stringLog= "Interrupted Process";
                break;
            case CONTEXT_SWITCH:
                this.stringLog= "Context Switch from process";
                break;
        }
    }

    public void stringEventToEnum(String event){
        this.eventKeywordS= event.toUpperCase();
        switch (event){
            case "CREATE":
                enumLog= Event.CREATE_PROCESS;
                break;
            case "EXECUTE":
                enumLog= Event.EXECUTE_PROCESS;
                break;
            case "TERMINATE":
                enumLog= Event.TERMINATE_PROCESS;
                break;
            case "READY":
                enumLog= Event.SENT_TO_READY_QUEUE;
                break;
            case "WAIT":
                enumLog= Event.SENT_TO_WAIT_QUEUE;
                break;
            case "CPU":
                enumLog= Event.SENT_TO_CPU;
                break;
            case "INTERRUPTED":
                enumLog= Event.INTERRUPTED;
                break;
            case "SWITCH":
                enumLog= Event.CONTEXT_SWITCH;
                break;
        }
        enumEventToString(enumLog);
        //output: Event.CREATE_PROCESS
    }

    //get current time and date
    public void createTimestamp(){
        LocalDateTime current = LocalDateTime.now();
        this.timeStamp = current.getNano() +" ";
    }

    public String eventDetail(String timeType, int time){
        return this.detail= timeType.toUpperCase() +" "+ time;
    }

    public String getTimestamp(){
        return this.timeStamp;
    }

 // user input getters
    public String getProcess(){
     return this.process;
 }

    public String getEventKeywordS(){
        return this.eventKeywordS;
    }

    public Event getEventKeywordE(){
        return this.eventKeywordE;
    }
// output getters
    public String getEnumEventToString(){
        return this.stringLog;
    }

    public Event getStringEventToEnum(){
        return this.enumLog;
    }
     //create and return details String

    public void createEventDetails(String timeType, int time){
        //create different detail objects
        //add to arraylist
        String type;
        type= eventDetail(timeType,time);
        arrayList.add(type);
    }

    public String getAllDetails(){
        return arrayList.toString();
    }

    // create event log and return event object
    public void createEventLog(String processName){
        this.process= processName;
        //getTimestamp(), getEnumEventToString(), processName,
        this.eventLog= new EventLog(getTimestamp(), getEnumEventToString(), process, getAllDetails());
    }
    public EventLog getEventLog(){
        return this.eventLog;
        //get time, get event, get process name, get process details (creation time, completion time ect)
    }

    public String eventLogToString(){
        String all = this.getTimestamp()+ "/ " +this.getEnumEventToString()+ ": " + this.getProcess()+ "/ Details: "+ this.getAllDetails();
        //empty arraylist
        arrayList.clear();
        return all;
    }
}
// use either enum-string or string-enum x1  AND createEventDetails xN function
// = current timestamp (timeStamp), event type(stringLog) AND saves event detail (arrayList...to be returned as string later)
// call getEventLog to eventLog: timestamp(String), event(String), processName(String), process details(detail)
// detail array empties when getEventLog is called to be reused
// eventLog object created and returned: current time, event, process name, details
// event log to be put in clock hashmap