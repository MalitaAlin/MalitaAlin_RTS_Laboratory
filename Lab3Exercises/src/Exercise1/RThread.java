package Exercise1;

import java.io.BufferedReader;
import java.sql.Date;

public class RThread extends Thread{

    FileService service;
    BufferedReader in;


    public RThread(FileService service,BufferedReader in) {

        this.service = service;
        this.in=in;
    }

    public void run(){

        while (!Main.isStopThreads()){

            try {

                synchronized (this.service){
                    String readMsg="no message to read";
                    String iterator;
                    while((iterator = in.readLine()) != null){
                        readMsg= new Date(System.currentTimeMillis()) + " - " + iterator;
                    }
                    System.out.println(readMsg);
                    notifyAll();
                }

                Thread.sleep(3000);

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

    }

}
