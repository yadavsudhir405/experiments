package github.com.yadavsudhir405.experiments.coreJavaPractise.collections;

import java.util.Queue;

/**
 * @author sudhir
 *         Date:10/4/17
 *         Time:4:56 PM
 *         Project:core-java-practise
 */
public class ArrayDequeueRunner {

    public static void main(String[] args) {
        check();
        /*ArrayDeque<Integer> integerArrayDeque=new ArrayDeque<>(2);
        integerArrayDeque.add(10);
        integerArrayDeque.add(20);
        integerArrayDeque.add(30);
        showElements(integerArrayDeque);
        integerArrayDeque.addFirst(40);
        System.out.println("*******************");
        showElements(integerArrayDeque);*/
    }
    private static void check(){
        int max=4;
        int i=0;
        System.out.println(6&4);
        while(i<=4){
            System.out.println(i&4);
            i++;
        }
    }
    public static void showElements(Queue<Integer> queue){
        for(Integer i:queue){
            System.out.println(i);
        }

    }
}
