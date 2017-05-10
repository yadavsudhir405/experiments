package github.com.yadavsudhir405.experiments.coreJavaPractise.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author sudhir
 *         Date:9/5/17
 *         Time:5:10 PM
 *         Project:core-java-practise
 */
public class LargeArrayInitializer {

    public int[] initializeArrayWithSize(int size){
        int[] array=new int[size];
        RandomInitRecursion randomInitRecursion=new RandomInitRecursion(array,0,size-1);
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        forkJoinPool.invoke(randomInitRecursion);
        return array;
    }

    private static class RandomInitRecursion extends RecursiveAction{
        private final static int THRESHOLD_SIZE=10;
        private final int[] array;
        private final int startIndex;
        private final int endIndex;
        RandomInitRecursion(int[] array,int startIndex,int endIndex){
            this.array=array;
            this.startIndex=startIndex;
            this.endIndex=endIndex;
        }

        @Override
        protected void compute() {
            int size=this.endIndex-this.startIndex;
            if(size<=THRESHOLD_SIZE){
                try {
                    initializeArray(array,this.startIndex,this.endIndex);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                int mid=size/2;
                RandomInitRecursion leftWork=new RandomInitRecursion(array,startIndex,startIndex+mid);
                RandomInitRecursion rightWork=new RandomInitRecursion(array,startIndex+mid+1,endIndex);
                leftWork.fork();
                rightWork.compute();
                leftWork.join();
            }
        }

        private void initializeArray(int[] array,int startIndex,int endIndex) throws InterruptedException {
            for(int i=startIndex;i<=endIndex;i++){
                array[i]= ThreadLocalRandom.current().nextInt(100);
            }
        }
    }
    public static void main(String[] args) {
        int[] array=new int[30];
        RandomInitRecursion randomInitRecursion=new RandomInitRecursion(array,0,29);
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        forkJoinPool.invoke(randomInitRecursion);
        System.out.println("Array Initialized");
        for(int i:array){
            System.out.print(String.format("%s ",i));
        }
    }

}
