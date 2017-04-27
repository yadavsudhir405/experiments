package github.com.yadavsudhir405.experiments.coreJavaPractise.algos;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author sudhir
 *         Date:27/4/17
 *         Time:9:34 AM
 *         Project:core-java-practise
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array={70,10,90,100,50,60,20,120,40};
        System.out.println("Before Sorting::");
        displayArray(array);
        System.out.println("After Sorting::");
        quickSort(array,0,array.length-1);
        displayArray(array);
    }
    private static void displayArray(int[] array){
        StringJoiner stringJoiner=new StringJoiner(",");
        Arrays.stream(array).forEach((value -> stringJoiner.add(String.valueOf(value))));
        System.out.println(stringJoiner.toString());
    }
    private static void quickSort(int[] array,int startIndex,int endIndex){
        Objects.requireNonNull(array);
        if(startIndex>=endIndex){
            return;
        }
        int pivotIndex=getPivotIndex(array,startIndex,endIndex);
        quickSort(array,0,pivotIndex-1);
        quickSort(array,pivotIndex+1,endIndex);
    }
    private static int getPivotIndex(int[] array,int startIndex,int endIndex){
        int pivotElement=array[endIndex];
        int pivotWallIndex=startIndex;
        for(int currentIndex=startIndex;currentIndex<endIndex;currentIndex++){
            int currentElement=array[currentIndex];
            if(currentElement<=pivotElement){
                putCurrentElementToTheLeftOfTheWall(array,pivotWallIndex,currentIndex);
                pivotWallIndex++;
            }
        }
        int temp=array[pivotWallIndex];
        array[pivotWallIndex]=pivotElement;
        array[endIndex]=temp;
        return pivotWallIndex;
    }
    private static void putCurrentElementToTheLeftOfTheWall(int[] array,int pivotIndex,int currentElementIndex){
        int temp=array[pivotIndex];
        array[pivotIndex]=array[currentElementIndex];
        array[currentElementIndex]=temp;
    }

}
