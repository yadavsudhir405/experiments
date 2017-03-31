package github.com.yadavsudhir405.experiments.coreJavaPractise.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author sudhir
 *         Date:30/3/17
 *         Time:5:57 PM
 *         Project:core-java-practise
 */
public class CopyOnWriteArrayListRunner {

    public static void main(String[] args) throws InterruptedException {

        int[] array={0,1,2,3};
        List<Integer> lsitss=new ArrayList<>();
        List<Integer> list= new CopyOnWriteArrayList<>();
        list.add(10);
        //List<Integer> list1=new CopyOnWriteArrayList<>(list);
        testFailFastOnArrayList(list);

    }
    private static void testFailFastOnArrayList(List<Integer> list) throws InterruptedException {
        Thread t1=new Thread(new ListReader(list));
        Thread t2=new Thread(new ListWriter(list));
        t1.start();
        t2.start();
        TimeUnit.MINUTES.sleep(1);
    }



    private static  class ListWriter implements Runnable{
        private final List<Integer> list;

        private ListWriter(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            System.out.println("Writer Thread");
            for(int i=1;i<10;i++){
                list.add(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static class ListReader implements Runnable{
        private final List<Integer> list;

        private ListReader(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            System.out.println("Reader Thread");
            for(int i:list){
                System.out.println(i+" by ReaderThread");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
