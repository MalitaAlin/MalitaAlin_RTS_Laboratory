package App4;

import java.util.Observable;
import java.util.Random;

public class Square extends Observable implements Runnable{
    private int id;
    private int x,y;

    Thread thread;
    private  static boolean endRun;
    private int processorLoad;
    private int invSpeed;




    public Square(int nr, int processorLoad) {
        this.processorLoad=processorLoad;
        this.x=40+nr*80;
        this.y=0;
        this.thread = new Thread(this);
        this.id=nr;
        Random random = new Random();
        invSpeed = random.nextInt(35)+5;
    }

    @Override
    public void run() {
        int c=0;
        while(!endRun){
            for(int j=0;j<this.processorLoad;j+=1){
                j++;
            }
            y++;
            try {
                Thread.sleep(invSpeed);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            refresh();
          
            this.setChanged();
            this.notifyObservers();

        }
    }


    public void refresh(){
        if(this.y>=420) {
            this.y=0;
        }

    }

    public void stop(){
        endRun=true;
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