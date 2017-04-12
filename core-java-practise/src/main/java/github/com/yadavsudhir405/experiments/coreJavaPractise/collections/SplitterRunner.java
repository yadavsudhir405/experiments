package github.com.yadavsudhir405.experiments.coreJavaPractise.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

/**
 * @author sudhir
 *         Date:10/4/17
 *         Time:3:44 PM
 *         Project:core-java-practise
 */
public class SplitterRunner {

    public static void main(String[] args) {
        splitterTest();
    }

    private static void splitterTest() {
        List<Integer> list= Arrays.asList(10,20,30,40,50,60);
        Spliterator<Integer> spliterator=list.spliterator();
        System.out.println(spliterator.characteristics());
        System.out.println(spliterator.estimateSize());


    }
}
