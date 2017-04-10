package oracle.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Provides sufficient test coverage for oracle.test.IteratorFlattener class.
 */
public class IteratorFlattenerTest {

    private List<List<Integer>> listList=new ArrayList<>();

    @Test
    public void displayInputs(){
        List<Integer> expected=Arrays.asList(1,2,3,4,5);
        listList= Arrays.asList(Arrays.asList(1,2),Arrays.asList(3),Arrays.asList(4,5));
        IteratorFlattener<Integer> integerIteratorFlattener=new IteratorFlattener(listList.iterator());
        List<Integer> integerList=new ArrayList<>();
        while (integerIteratorFlattener.hasNext()){
            integerList.add(integerIteratorFlattener.next());
        }
        Assert.assertEquals(expected,integerList);
    }
}