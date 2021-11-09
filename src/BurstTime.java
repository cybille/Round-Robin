public class BurstTime {
    int burstTime;

    public BurstTime(){
        this.burstTime= 1; //default
    }

    public BurstTime(int burstTime){
        this.burstTime= burstTime;
    }

    //set
    public void setBurstTime(int burstTime){
        this.burstTime= burstTime;
    }
    //return
    public int getBurstTime() {
        return this.burstTime;
    }

    public boolean isZero(){
        if(this.burstTime != 0)
            return true;
        else
            return false;
    }
    public int increment(){
        int newTime;
        newTime= this.burstTime+1;
        this.burstTime = newTime;

        return this.burstTime;

    }

    public int decrement(){
        int newTime;
        if (!isZero()){
            newTime= this.burstTime-1;
        }
        else {
            newTime= this.burstTime;
        }
        this.burstTime = newTime;
        return this.burstTime;

    }
}
