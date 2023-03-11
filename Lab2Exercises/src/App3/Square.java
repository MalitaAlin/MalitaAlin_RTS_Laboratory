package App3;

import java.util.Observable;
import java.util.Random;

public class Square extends Observable implements Runnable{
    private int id;
    private int x,y;
 
    Thread thread;
    private  static boolean endRun; //if endRun is not static, all threads stop independently of each other
    private int processorLoad;
    private int invSpeed;


    public Square(int nr, int processorLoad) {
        this.processorLoad=processorLoad;
        this.x=50+nr*80;
        this.y=0;
        this.thread = new Thread(this);
        this.id=nr;
        Random random = new Random();
        invSpeed = random.nextInt(35)+5; //inverse of speed 5=max; 35=min
    }

    @Override
    public void run() {
        int c=0;
        while(!endRun){
            for(int j=0;j<this.processorLoad;j++){
                j++;
            }
            c++;
            try {
                Thread.sleep(invSpeed);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            stop();
            y=c;
            this.setChanged();
            this.notifyObservers();

        }
    }


    public void stop(){
        if(y>=420) 
            this.endRun = true;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

