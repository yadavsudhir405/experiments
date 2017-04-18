package github.com.yadavsudhir405.experiments.coreJavaPractise.collections;

import java.lang.reflect.Array;

/**
 * @author sudhir
 *         Date:15/4/17
 *         Time:6:14 PM
 *         Project:core-java-practise
 */
public class IArrays {
    private IArrays(){
        throw new AssertionError("Object Instantiation is not allowed");
    }
    public static <T,U> T[] copyOf(U[] original,int size,Class<? extends T> newType){
        T[] copy=((Object)original.getClass()==(Object) Object[].class)?(T[])new Object[size]:
                (T[]) Array.newInstance(newType.getComponentType(),size);
        System.arraycopy(original,0,copy,0,size);
        return copy;
    }
    public static <T,U> T[] copyOfRange(U[] original,int from,int to,Class<? extends T> newType){
        int newLength=to-from;
        if(newLength<0) throw new IllegalArgumentException(from+" > "+to);
        T[] copy=((Object)original.getClass()==(Object) Object[].class)?
                (T[])new Object[newLength]: (T[]) Array.newInstance(newType.getComponentType(),newLength);
        System.arraycopy(original,from,copy,0,newLength);
        return copy;
    }

}
