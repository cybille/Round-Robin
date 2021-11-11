public class TimeChange {
    int burstTime;
    int arrivalTime;

    public TimeChange(){}

    //set
    public void setArrivalTime(int arrivalTime){
        this.arrivalTime= arrivalTime;
    }

    //set
    public void setBurstTime(int burstTime){this.burstTime= burstTime;}


    public boolean isNotZeroBurstTime(){
        if(this.burstTime != 0)
            return true;
        else
            return false;
    }
    public int incrementBurstTime(){
        int newTime;
        newTime= this.burstTime+1;
        this.burstTime = newTime;

        return this.burstTime;

    }

    public int decrementBurstTime(){
        int newTime;
        if (isNotZeroBurstTime()){
            newTime= this.burstTime-1;
        }
        else {
            newTime= this.burstTime;
        }
        this.burstTime = newTime;
        return this.burstTime;

    }



    public int nextBurst(){
        return this.burstTime--;
    }

    //return
    public int getArrivalTime() {
        return this.arrivalTime;
    }

    //return
    public int getBurstTime() {
        return this.burstTime;
    }


}
