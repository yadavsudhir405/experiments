package github.com.yadavsudhir405.experiments.coreJavaPractise.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author sudhir
 *         Date:11/4/17
 *         Time:11:39 PM
 *         Project:core-java-practise
 */
public class ForkJoinTaskRunner {
    public static void main(String[] args) {
            //startInitializingArrayWithRandomNumber();

    }

    private static void startInitializingArrayWithRandomNumber() {
        int[] data=new int[100];
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        RandomInitRecursiveActionTask randomInitRecursiveActionTask=new RandomInitRecursiveActionTask(data,0,99);
        forkJoinPool.invoke(randomInitRecursiveActionTask);
    }
    private static class FindMaxPositionRecursiveTask extends RecursiveTask<Integer>{
        private static final int THRESHOLD=20;
        private final int[] data;
        private final int startIndex;
        private final int endIndex;

        public FindMaxPositionRecursiveTask(int[] data, int startIndex, int endIndex) {
            this.data = data;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
        @Override
        protected Integer compute() {
            if(endIndex-startIndex<=20){
                int position=startIndex;
                for(int i=startIndex;i<=endIndex;i++){
                    if(data[position]>data[i]){
                        position=i;
                    }
                }
                return position;
            }else{
                int index=(endIndex-startIndex)/2+1;
                FindMaxPositionRecursiveTask firstHalfTask=new FindMaxPositionRecursiveTask(data,startIndex,index);
                FindMaxPositionRecursiveTask secondHalfTask=new FindMaxPositionRecursiveTask(data,
                        index+1,endIndex);
                firstHalfTask.fork();
                int position1=secondHalfTask.compute();
                int position2=firstHalfTask.join();
                if(data[position1]>data[position2]){
                    return position1;
                }else if(data[position1]<data[position2]){
                    return position2;
                }else{
                    return position1<=position2?position1:position2;
                }
            }
        }
    }

    private static class RandomInitRecursiveActionTask extends RecursiveAction{
        private static final int THRESHOLD=20;
        private final int[] data;
        private  final int startIndex;
        private  final int endIndex;

        private RandomInitRecursiveActionTask(int[] data, int startIndex, int endIndex) {
            this.data = data;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        protected void compute() {
            if(endIndex-startIndex<=THRESHOLD){
                for(int i=startIndex;i<=endIndex;i++){
                    data[i]= ThreadLocalRandom.current().nextInt();
                }
            }else{
                int index=(endIndex-startIndex)/2+startIndex;
                RandomInitRecursiveActionTask firstHalfTak=new RandomInitRecursiveActionTask(data,startIndex,index);
                firstHalfTak.fork();
                RandomInitRecursiveActionTask secondHalfTask=new RandomInitRecursiveActionTask(data,index+1,endIndex);
                secondHalfTask.compute();
                firstHalfTak.join();
            }
        }
    }



    private static class FolderProcessor extends RecursiveTask<List<String>>{
        private final String path;
        private final String extension;

        private FolderProcessor(String path, String extension) {
            this.path = path;
            this.extension = extension;
        }

        @Override
        protected List<String> compute() {
            List<String> list=new ArrayList<>();
            return null;
        }
    }
}
