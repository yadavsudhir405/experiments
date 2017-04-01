package github.com.yadavsudhir405.experiments.coreJavaPractise.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author sudhir
 *         Date:31/3/17
 *         Time:8:03 PM
 *         Project:core-java-practise
 */
public class FutureTaskEampleRunner {
    private static final ExecutorService EXECUTOR= Executors.newCachedThreadPool();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        startTest();
        //WaitTask waitTask=new WaitTask(12);
        //FutureTask<String> futureTask=new FutureTask<String>(waitTask,"Done");
        //EXECUTOR.execute(futureTask);
        //System.out.println(futureTask.get());
        //futureTask.run();
       // EXECUTOR.awaitTermination(25,SECONDS);
       // EXECUTOR.shutdown();

    }
    private static class WaitTask implements Runnable{
        private final long waitTime;

        private WaitTask(long waitTime) {
            this.waitTime = waitTime;
        }

        @Override
        public void run() {
            try {
                System.out.println("WaitTask being run by "+Thread.currentThread().getName());
                SECONDS.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void startTest() throws ExecutionException, InterruptedException {
        Callable<String> callable1=new CustomCallable(15);
        Callable<String> callable2=new CustomCallable(20);
        List<Callable<String>> callableList=new ArrayList<Callable<String>>(){
            {
                add(callable1);
                add(callable2);
            }
        };
        List<Future<String>> results= EXECUTOR.invokeAll(callableList,10,SECONDS);
        System.out.println("Timed-out Happend after Invoking Task1 and task2");
        /*FutureTask<String> futureTask1=new FutureTask<String>(callable1);
        FutureTask<String> futureTask2=new FutureTask<String>(callable2);
        EXECUTOR.execute(futureTask1);
        EXECUTOR.execute(futureTask2);
        boolean isThreadOneNotNotified=true;
        boolean isThreadTwoNotNotified=true;
        while (true){
            if(futureTask1.isDone()&&futureTask2.isDone()){
                System.out.println("Both task got completed");
                break;
            }
            if(futureTask1.isDone()&& isThreadOneNotNotified){
                System.out.println("Task1 got completed");
                System.out.println("task 1 was being executed by "+futureTask1.get());
                isThreadOneNotNotified=false;
            }
            if(futureTask2.isDone()&&isThreadTwoNotNotified){
                System.out.println("task2 got completed");
                isThreadTwoNotNotified=false;
                System.out.println("task 2 was being executed by "+futureTask2.get());

            }
        }*/
    }

    private static class CustomCallable implements Callable<String>{
         private final long waitime;

        private CustomCallable(long waitime) {
            this.waitime = waitime;
        }

        @Override
        public String call() throws Exception {
            try{
                SECONDS.sleep(waitime);
            }catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName()+" has been interrupted");
            }
            System.out.println(Thread.currentThread().getName()+" has been completed");
            return Thread.currentThread().getName();
        }
    }
}
