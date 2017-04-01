package github.com.yadavsudhir405.experiments.coreJavaPractise.exceptions;

/**
 * @author sudhir
 *         Date:1/4/17
 *         Time:3:15 PM
 *         Project:core-java-practise
 */
public class FinallyExceptionTest {
    public static void main(String[] args) {
        System.out.println(s());
    }

    public static int s(){
        try{
            System.out.println("Before Throwing exception");
            //throw new NullPointerException();
            //return 1;
            System.exit(0);
            return 1;
        }catch (NullPointerException e){

        }finally {
            System.out.println("Finally");
            return 2;
        }
    }
}
