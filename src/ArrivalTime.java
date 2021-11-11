public class ArrivalTime {
    int arrivalTime;

    public ArrivalTime(){
        this.arrivalTime= 1; //default
    }

    public ArrivalTime(int arrival){
        this.arrivalTime= arrival;
    }

    //set
    public void setArrivalTime(int arrival){
        this.arrivalTime= arrival;
    }
    //return
    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public boolean isZeroArrivalTime(){
        if(this.arrivalTime != 0)
            return true;
        else
            return false;
    }
    public int incrementArrivalTime(){
        int newTime;
        newTime= this.arrivalTime+1;
        this.arrivalTime = newTime;

        return this.arrivalTime;

    }

    public int decrementArrivalTime(){
        int newTime;
        if (isZeroArrivalTime()){
            newTime= this.arrivalTime-1;
        }
        else {
            newTime= this.arrivalTime;
        }
        this.arrivalTime = newTime;
        return this.arrivalTime;

    }

    public int nextArrival(){
        return arrivalTime++;
    }
}
