package github.com.yadavsudhir405.experiments.coreJavaPractise.collections;

/**
 * @author sudhir
 *         Date:10/4/17
 *         Time:2:46 PM
 *         Project:core-java-practise
 */
public class ArrayStackRunner {

    public static void main(String[] args) {

        int i=1;
        int j=5;
        System.out.println(17 & 15);


        ArrayStack<Integer> arrayStack=new ArrayStack<>(5);
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        arrayStack.push(40);
        arrayStack.push(50);
        arrayStack.push(60);
        ArrayStack<Integer>.IIterator<Integer> itr=arrayStack.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
