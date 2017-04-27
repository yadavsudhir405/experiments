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
        int[] array={60,50,10,70};
        System.out.println("Before Sorting::");
        displayArray(array);
        System.out.println("After Sorting::");
        quickSort(array,0,array.length-1);
        displayArray(array);
        Character[] characters={'Z','A','D','B','C','G','F'};
        System.out.println("Before Sorting Characters:::");
        displayGenericArray(characters);
        System.out.println("After Sorting Characters:::");
        IArrays.sort(characters);
        displayGenericArray(characters);

        Person[] persons={new Person("Sudhir",60),new Person("Sudhir",50),new Person("Sudhir",10),new Person
                ("Sudhir",70),new Person("Sudhir",100),new Person("Sudhir",5)};
        IArrays.sort(persons,(a1,a2)->{
            if(a1.age>a2.age){
                return 1;
            }else if(a1.age<a2.age){
                return -1;
            }else{
                return 0;
            }
        });
        displayGenericArray(persons);
    }

    private static <T> void displayGenericArray(T[] array){
        StringJoiner stringJoiner=new StringJoiner(",");
        Arrays.stream(array).forEach((value -> stringJoiner.add(value.toString())));
        System.out.println(stringJoiner.toString());
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
    private static class Person{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
