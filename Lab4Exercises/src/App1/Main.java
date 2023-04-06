package App1;
public class Main {
    public static void main(String[] args){
        Integer monitor = new Integer(1);
        new ExecutionThread(monitor,4,2,4).start();
        new ExecutionThread(monitor,3,3,6).start();
        new ExecutionThread(monitor,5,2,5).start();
    }
}

class ExecutionThread extends Thread {
    Integer monitor;
    int sleepvalue, activity_max,activity_min;

    public ExecutionThread(Integer monitor, int sleepvalue,int activity_min,int activity_max){
        this.monitor=monitor;
        this.sleepvalue=sleepvalue;
        this.activity_min=activity_min;
        this.activity_max=activity_max;
    }

    public void run(){
        System.out.println(this.getName() + " - STATE 1");
        synchronized (monitor){
            System.out.println(this.getName() + " - STATE 2");
            int k = (int) Math.round(Math.random() * (activity_max-activity_min) + activity_min);
            for(int i=0; i<k*100000;i++){
                i++;i--;
            }
        }
        try{
            Thread.sleep(Math.round((Math.random() * sleepvalue)) * 500);

        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println(this.getName() + " - STATE 3");
    }
}