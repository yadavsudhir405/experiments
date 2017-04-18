package github.com.yadavsudhir405.experiments.coreJavaPractise.collections.maps;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author sudhir
 *         Date:16/4/17
 *         Time:3:34 PM
 *         Project:core-java-practise
 */
public class ICollections {
    private ICollections(){

    }

    public static <T> T[] toArray(Collection<T> collection){
        int size=collection.size();
        T[] array=(T[]) new Object[size];
        int i=0;
        for(T t:collection){
            array[i++]=t;
        }
        return array;
    }
    public static <T> T[] toArray(Collection<T> collection,T[] array){

        array=(collection.size()>array.length)? (T[])Array.newInstance(array.getClass().getComponentType(),collection
                .size()):array;
        return array;
    }

    public static void main(String[] args) {
        List<String> list= Arrays.asList("Bangalore","Delhi");
        String[] cities=toArray(list);
    }
}
