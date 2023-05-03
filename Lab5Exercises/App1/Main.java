package MalitaAlin_RTS_Laboratory.Lab5Exercises.App1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Fir extends Thread {

    int name;

    Lock l;

    Fir(int n, Lock la) {

        this.name = n;

        this.l = la;

    }

    public void run() {

        this.l.lock();

        System.out.println("The thread " + name + " acquired the lock");

        criticalRegion();

        this.l.unlock();

        System.out.println("The thread " + name + " released the lock");

    }

    public void criticalRegion() {

        System.out.println("IS EXECUTING THE CRITICAL REGION!");

        try {

            Thread.sleep(3000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

    }

}

public class Main {

    public static void main(String args[]) {

        Lock l = new ReentrantLock();

        Fir f1, f2;

        f1 = new Fir(1, l);

        f2 = new Fir(2, l);

        f1.start();

        f2.start();

    }

}