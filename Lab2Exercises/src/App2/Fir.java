package App2;

import java.util.Observable;

public class Fir extends Observable implements Runnable  {
    
    int id;
    int val;
    int processorLoad;
    Thread thread;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

  public int getVal() {
        return val;
    }
    public void setVal(int val) {
        this.val = val;
    }

     Fir(int id, int priority, int procLoad){ 
              this.id=id;
             thread= new Thread(this);
              this.processorLoad=procLoad;
              this.thread.setPriority(priority);
     }

     @Override
     public void run(){
         int c=0;
         while(c<1000){
             for(int j=0;j<this.processorLoad;j++){
                 j++;j--;
             }
             c++;
             
             val=c;
             try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
             this.setChanged();
             this.notifyObservers();
         }
     }

}
