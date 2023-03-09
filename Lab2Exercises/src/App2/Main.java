package App2;
//  Laboratory 2 Exercises

public class Main {
          private static final int noOfThreads=6;
          private static final int processorLoad=1000000;
          public static void main(String args[]){
                     //for(int i =0; i<noOfThreads; i++){
                       //        new Fir(i,i+2,processorLoad).start();
                        //}
                        Window win=new Window(noOfThreads);
                        Fir fir;
                        for(int i =0; i<noOfThreads; i++){
                            fir = new Fir(i,i+2,processorLoad);
                            fir.addObserver(win);
                            fir.thread.start();
            }

}
}



