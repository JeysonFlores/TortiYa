package Clases;

public class SimpleTimer {
    
    private long StartTime;
    
    public void Start(){
        StartTime = System.currentTimeMillis();
    }
    
    public int ElapsedTime(){
        return (int) (System.currentTimeMillis() - StartTime) / 1000;
    }
    
    public int ElapsedTimeMilis(){
        return (int) (System.currentTimeMillis() - StartTime);
    }
    
    public int ElapsedTimeRemainingMilis(int Milis){
        int Time = ElapsedTimeMilis();
        return Milis - Time;
    }
    
    public String ElapsedTimeRemaining(int Minutes){
        int Time = ElapsedTime();
        int TimeTotal = Minutes * 60;
        int Time2 = TimeTotal - Time;
        int Minuts = Time2 / 60;
        int Secs = Time2 % 60;
        if(Secs>9)
            return "0"+Minuts+":"+Secs;
        else
           return "0"+Minuts+":0"+Secs;
    }
    
    public String ElapsedTimeRemainingMilisString(int milis){
        int TimeTotal = milis / 1000;
        int Minuts = TimeTotal / 60;
        int Seconds = TimeTotal % 60;
        if(Seconds>9){
            return "0"+Minuts+":"+Seconds;
        }
        else{
            return "0"+Minuts+":0"+Seconds;
        }
    }
    
    public int ElapsedTimeRemainingInt(int Minutes){
        int Time = ElapsedTime();
        int TimeTotal = Minutes * 60;
        int Time2 = TimeTotal - Time;
        return Time2;
    }
    
    public String ElapsedTimeLong(){
        int Time = ElapsedTime();
        int Minuts = Time / 60;
        int Secs = Time % 60;
        if(Secs>9)
            return "0"+Minuts+":"+Secs;
        else
           return "0"+Minuts+":0"+Secs;   
    }
    
}
