public class ArrivalTime {
    int arrivalTime;

    public ArrivalTime(){
        this.arrivalTime= 1; //default
    }

    public ArrivalTime(int burstTime){
        this.arrivalTime= burstTime;
    }

    //set
    public void setArrivalTime(int burstTime){
        this.arrivalTime= burstTime;
    }
    //return
    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public boolean isZero(){
        if(this.arrivalTime != 0)
            return true;
        else
            return false;
    }
    public int increment(){
        int newTime;
        newTime= this.arrivalTime+1;
        this.arrivalTime = newTime;

        return this.arrivalTime;

    }

    public int decrement(){
        int newTime;
        if (isZero()){
            newTime= this.arrivalTime-1;
        }
        else {
            newTime= this.arrivalTime;
        }
        this.arrivalTime = newTime;
        return this.arrivalTime;

    }
}
