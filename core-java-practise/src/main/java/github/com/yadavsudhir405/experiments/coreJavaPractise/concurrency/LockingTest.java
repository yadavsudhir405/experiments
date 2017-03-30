package github.com.yadavsudhir405.experiments.coreJavaPractise.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sudhir
 *         Date:30/3/17
 *         Time:10:44 AM
 *         Project:core-java-practise
 */
public class LockingTest {
    private  final int max_Size;
    private  final List<Integer> list;
    private volatile int currentSize=0;

    public LockingTest(int max_Size) {
        this.max_Size = max_Size;
        list=new ArrayList<>(max_Size);
    }

    public void add(Integer element){
        synchronized (list){
            while (list.size()>=max_Size){
                try {
                    System.out.println("Waiting thread to add element: "+Thread.currentThread().getName());
                    list.wait();
                    System.out.println("Woke up to add element: "+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            list.add(element);
            System.out.println("Added element: "+element);
            list.notify();
        }

    }

    public Integer removeElement(){
        synchronized (list){
            while (list.size()<=0){
                try {
                    System.out.println("Waiting thread to remove element: "+Thread.currentThread().getName());
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Woke up to remove element: "+Thread.currentThread().getName());
           int el=list.remove(list.size()-1);
            list.notify();
            return el;
       }

    }
}
