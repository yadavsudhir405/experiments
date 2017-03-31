package github.com.yadavsudhir405.experiments.coreJavaPractise.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sudhir
 *         Date:30/3/17
 *         Time:4:02 PM
 *         Project:core-java-practise
 */
public class printingOddEvenWithCondition {

    private static final Lock lock=new ReentrantLock();
    public static void main(String[] args) {
        ReentrantLock lock1=(ReentrantLock) lock;
        System.out.println(lock1.getHoldCount());
        lock1.lock();
        System.out.println(lock1.getHoldCount());

        lock1.lock();
        System.out.println(lock1.getHoldCount());
        /*Displayer displayer=new Displayer();
        Thread thread1=new Thread(new EvenNumberProducer(displayer),"EvenProducer");
        Thread thread2=new Thread(new OddNumberProducer(displayer),"OddProducer");
        thread1.start();
        thread2.start();*/
    }
    private static class OddNumberProducer implements Runnable{

        private final Displayer displayer;

        public OddNumberProducer(Displayer displayer) {
            this.displayer = displayer;
        }

        @Override
        public void run() {
            for(int i=1;i<=9;i=i+2){
                try {
                    displayer.display(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class EvenNumberProducer implements Runnable{
        private final Displayer displayer;

        public EvenNumberProducer(Displayer displayer) {
            this.displayer = displayer;
        }

        @Override
        public void run() {
            for(int i=2;i<=10;i=i+2){
                try {
                    displayer.display(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static class Displayer{
        private final Lock lock=new ReentrantLock();
        private final Condition displayOddNumberCondition=lock.newCondition();
        private final Condition displayEvenNumberCondition=lock.newCondition();
        private volatile boolean isOddTurn=true;
        private volatile boolean isEvenTurn=false;

        public void display(int i) throws InterruptedException {
            try{
                lock.lock();
                while(i%2!=0&&!isOddTurn){
                    displayOddNumberCondition.await();

                }
                while(i%2==0&&!isEvenTurn){
                    displayEvenNumberCondition.await();
                }
                System.out.println(i+" by "+Thread.currentThread().getName());
                if(i%2!=0){
                    //Displayed Odd number so notify even one
                    isOddTurn=false;
                    isEvenTurn=true;
                    displayEvenNumberCondition.signal();

                }else{
                    isEvenTurn=false;
                    isOddTurn=true;
                    displayOddNumberCondition.signal();
                }
            }finally {
                lock.unlock();
            }

        }
    }
}
