package github.com.yadavsudhir405.experiments.coreJavaPractise.generics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sudhir
 *         Date:15/4/17
 *         Time:4:04 PM
 *         Project:core-java-practise
 */
public class Genericsrunner {
    public static <T> List<T> toList(T[] array){
        List<T> list=new ArrayList<T>();
        for(T t:array){
            list.add(t);
        }
        return list;
    }

    public static <T> List<T> toList(List<T> list,T... array){

        for(T t:array){
            list.add(t);
        }
        return list;
    }
    public static <T> T[] toArray(List<T> list){
        T[] array=(T[]) new Object[0];
        return list.toArray(array);
    }

    public static <T,U> T[] copyOf(U[] original,int size,Class<? extends T[]> newType){
        T[] copy=((Object)newType==(Object) Object[].class)?(T[])new Object[size]:
                (T[])Array.newInstance(newType.getComponentType(),size);
        System.arraycopy(original,0,copy,0,Math.min(original.length,size));
        return copy;
    }

    public static void main(String[] args) {
        int[] intsArray={10,20};
        System.out.println(intsArray.getClass().getComponentType());
        String test="test";
        System.out.println(test.getClass().getComponentType());

        String[] strings={"Bangalore","Delhi"};

        Object[] stringsss= copyOf(strings,2, new Object[1].getClass());

        List<String> cities= Arrays.asList("Bangalore","Delhi");
        String [] cityArray=toArray(cities);

        /*if(strings instanceof Array){
            System.out.println("Instance of Array");
        }else if(strings instanceof String[]){
            System.out.println("String Array");
            strings=(String[])strings;
        }*/
    }
}
