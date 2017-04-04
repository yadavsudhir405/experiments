package github.com.yadavsudhir405.experiments.coreJavaPractise.generals;

import java.util.concurrent.TimeUnit;

/**
 * @author sudhir
 *         Date:2/4/17
 *         Time:10:01 PM
 *         Project:core-java-practise
 */
public class ThreadRunner {
    public static void main(String[] args) throws InterruptedException {
        MycustomThread mycustomThread=new MycustomThread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println("Hello");
                }
            }
        });
        mycustomThread.start();
        TimeUnit.SECONDS.sleep(5);
    }
    private static class MycustomThread implements Runnable{
        private final Runnable runnable;
        private Thread thread;
        private MycustomThread(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override
        public void run() {
            if(runnable!=null){
                runnable.run();
            }

        }
        public void start(){
             thread=new Thread(runnable);
            thread.start();
        }
        public void interrupt(){
            thread.interrupt();
        }
    }
}
