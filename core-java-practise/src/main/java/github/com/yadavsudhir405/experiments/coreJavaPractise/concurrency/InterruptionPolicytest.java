package github.com.yadavsudhir405.experiments.coreJavaPractise.concurrency;

import java.util.concurrent.*;

/**
 * @author sudhir
 *         Date:4/4/17
 *         Time:10:05 AM
 *         Project:core-java-practise
 */
public class InterruptionPolicytest {
    private static final ExecutorService EXECUTOR= Executors.newSingleThreadExecutor();
    private static final BlockingQueue<Integer> BLOCKING_QUEUE=new ArrayBlockingQueue<Integer>(1);
    public static void main(String[] args) throws InterruptedException {
        try {
            Task task1=new Task(BLOCKING_QUEUE);
            Task task2=new Task(BLOCKING_QUEUE);
            System.out.println("Starting task1");
            Future<?> futureTask=EXECUTOR.submit(task1);
            TimeUnit.SECONDS.sleep(3);
           // System.out.println("Interrupting task1 and starting task2");
            futureTask.cancel(true);
            EXECUTOR.execute(task2);
        }finally {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Shutting Down Executer");
            EXECUTOR.shutdown();
            System.out.println("Waiting for 5 seconds to shutDown");
            EXECUTOR.awaitTermination(5,TimeUnit.SECONDS);
            //EXECUTOR.shutdownNow();
            System.out.println("Executor shutDown");
            System.out.println("Executor is shutDown "+EXECUTOR.isShutdown());
            System.out.println("All tasks completed  following shutdown "+EXECUTOR.isTerminated());
        }

    }
    private static class Task implements Runnable{
        private final BlockingQueue<Integer> blockingQueue;
        private Task(BlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            System.out.println("Starting Thread "+Thread.currentThread().getName());
            while(!Thread.currentThread().isInterrupted()){
                System.out.println(getValueFromQueue());
            }
        }
        public void cancel(){
            Thread.currentThread().interrupt();
        }
        private int getValueFromQueue(){
            boolean isInterrupted=false;
            try{
                while(!isInterrupted){
                    try {
                        System.out.println("Running thread is "+Thread.currentThread().getName());
                        return blockingQueue.take();
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName()+" is interrupted and Interrupted status " +
                                ""+Thread.currentThread().isInterrupted());
                        isInterrupted=true;
                    }
                }
            }finally {
                Thread.currentThread().interrupt();
            }


            return -1;
        }

    }
}
