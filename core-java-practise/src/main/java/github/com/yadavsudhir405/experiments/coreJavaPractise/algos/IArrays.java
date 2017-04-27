package github.com.yadavsudhir405.experiments.coreJavaPractise.algos;

import java.util.Comparator;

/**
 * @author sudhir
 *         Date:27/4/17
 *         Time:4:24 PM
 *         Project:core-java-practise
 */
public class IArrays {

    public static <T extends Comparable<T>>  void sort(T[] array){
        quickSort(array,0,array.length-1);
    }
    private static <T extends Comparable<T>> void quickSort(T[] array, int startIndex, int endIndex) {
        if(startIndex>=endIndex){
            return;
        }
        int pivotIndex=getPivotIndex(array,startIndex,endIndex);
        quickSort(array,startIndex,pivotIndex-1);
        quickSort(array,pivotIndex+1,endIndex);
    }

    private static <T extends Comparable<T>> int getPivotIndex(T[] array, int startIndex, int endIndex) {
        T pivotElement=array[endIndex];
        int pivotWallIndex=startIndex;
        for(int currentIndex=startIndex;currentIndex<endIndex;currentIndex++){
            if(pivotElement.compareTo(array[currentIndex])>=0){
                putCurrentElementToRightOfWall(array,pivotWallIndex,currentIndex);
                pivotWallIndex++;
            }
        }
        swapArrayElements(array,pivotWallIndex,endIndex);
        return pivotWallIndex;
    }

    public static <T> void sort(T[] array, Comparator<T> comparator){
            quickSort(array,comparator,0,array.length-1);
    }
    private static <T> void quickSort(T[] array,Comparator<T> comparator,int startIndex,int endIndex){
        if(startIndex>=endIndex){
            return;
        }
        int pivotIndex=getPivotIndex(array,comparator,startIndex,endIndex);
        quickSort(array,comparator,startIndex,pivotIndex-1);
        quickSort(array,comparator,pivotIndex+1,endIndex);
    }

    private static <T> int getPivotIndex(T[] array, Comparator<T> comparator, int startIndex, int endIndex) {
        T pivotElement=array[endIndex];
        int pivotWallIndex=startIndex;
        for(int currentIndex=startIndex;currentIndex<endIndex;currentIndex++){
            if(comparator.compare(pivotElement,array[currentIndex])>=0){
                putCurrentElementToRightOfWall(array,pivotWallIndex,currentIndex);
                pivotWallIndex++;
            }
        }
        swapArrayElements(array,pivotWallIndex,endIndex);
        return pivotWallIndex;
    }

    private static <T> void putCurrentElementToRightOfWall(T[] array,int pivotIndex,int currentIndex){
        swapArrayElements(array,pivotIndex,currentIndex);
    }
    private static <T> void swapArrayElements(T[] array,int i,int j){
        T temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
