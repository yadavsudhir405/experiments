package github.com.yadavsudhir405.experiments.coreJavaPractise.concurrency;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author sudhir
 *         Date:9/5/17
 *         Time:5:41 PM
 *         Project:core-java-practise
 */
public class SortingLargeArray {

    public static void main(String[] args) {
        LargeArrayInitializer largeArrayInitializer=new LargeArrayInitializer();
        int[] unsortedArray=largeArrayInitializer.initializeArrayWithSize(30);
        LargerArraySorter largerArraySorter=new LargerArraySorter();
        largerArraySorter.sort(unsortedArray);
        displayArray(unsortedArray);
    }

    private static void displayArray(int[] unsortedArray) {
        Arrays.stream(unsortedArray).forEach(i->{System.out.print(String.format("%s ",i));});
    }

    private static class LargerArraySorter {

        public void sort(int[] array){
            ForkJoinPool forkJoinPool=new ForkJoinPool();
            forkJoinPool.invoke(new ArraySorter(array,0,array.length-1));
        }
        private static class ArraySorter extends RecursiveAction {
            public static final int THRESHOLD_SIZE=10;
            private final int[] array;
            private final int startIndex;
            private final int endIndex;

            public ArraySorter(int[] array, int startIndex, int endIndex) {
                this.array = array;
                this.startIndex = startIndex;
                this.endIndex = endIndex;
            }

            @Override
            protected void compute() {
                int size=this.endIndex-this.startIndex;
                if(size<=THRESHOLD_SIZE){
                    sortArray(array,startIndex,endIndex);
                }else{
                    int mid=size/2;
                    ArraySorter leftHalfSorter=new ArraySorter(array,this.startIndex,this.startIndex+mid);
                    ArraySorter rightHalfSorter=new ArraySorter(array,this.startIndex+mid+1,this.endIndex);
                    leftHalfSorter.fork();
                    rightHalfSorter.compute();
                    leftHalfSorter.join();
                }
            }

            private void sortArray(int[] array, int startIndex, int endIndex) {
                Arrays.sort(array,startIndex,endIndex);
            }
        }


    }

}
