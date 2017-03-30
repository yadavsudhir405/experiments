package github.com.yadavsudhir405.experiments.coreJavaPractise.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author sudhir
 *         Date:30/3/17
 *         Time:11:20 AM
 *         Project:core-java-practise
 */
public class LockingTestRunner {
    public static void main(String[] args) throws InterruptedException {
        LockingTest lockingTest=new LockingTest(5);
        Producer producer=new Producer(lockingTest);
        Consumer consumer=new Consumer(lockingTest);
        Thread producerThread=new Thread(producer,"Producer");
        Thread consumerThread=new Thread(consumer,"Consumer");
        consumerThread.start();
        TimeUnit.SECONDS.sleep(3);
        producerThread.start();
    }
    public static class Producer implements  Runnable{

        private final LockingTest lockingTest;


        public Producer(LockingTest lockingTest) {
            this.lockingTest = lockingTest;
        }

        @Override
        public void run() {
            for(int i=1;i<15;i++){
                lockingTest.add(i);
            }
        }
    }
    public static class Consumer implements  Runnable{

        private final LockingTest lockingTest;


        public Consumer(LockingTest lockingTest) {
            this.lockingTest = lockingTest;
        }

        @Override
        public void run() {
            for(int i=1;i<15;i++){
                int c=lockingTest.removeElement();
                System.out.println("Removed element to list "+c);
            }
        }
    }
}
