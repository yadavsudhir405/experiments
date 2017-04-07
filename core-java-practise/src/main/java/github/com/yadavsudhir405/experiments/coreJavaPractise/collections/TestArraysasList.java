package github.com.yadavsudhir405.experiments.coreJavaPractise.collections;

import java.util.*;

/**
 * @author sudhir
 *         Date:5/4/17
 *         Time:10:19 AM
 *         Project:core-java-practise
 */
public class TestArraysasList {
    public static void main(String[] args) {
        /*Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        Collection<Integer> values=map.values();
        values.add(90);
        values.remove(3);*/


       /* HashSet<Integer> set=new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Integer[] ints=new Integer[10];
        ints[5]=100;
        ints[6]=200;
        ints=set.toArray(ints);
        displayArray(ints);
        displaySet(set);
        set.add(4);
        System.out.println("After modifying set");
        displayArray(ints);
        displaySet(set);*/

        List<Integer> list=new ArrayList<>(20);


    }
    static void displaySet(Set<Integer> set){
        System.out.println(set);
    }
    static  <T> void  displayArray(T[] a){
      for(int i=0;i<a.length;i++){
          System.out.println(a[i]+" ");
      }
    }
    private static class Test{
        public void display(int i){
            System.out.println("Inside int");
        }
        public void display(Integer i){
            System.out.println("Inside Integer");
        }
        public void display(String str){
            System.out.println("Inside str");
        }
        public void display(Object i){
            System.out.println("Inside Object");
        }
    }
}
