package github.com.yadavsudhir405.experiments.coreJavaPractise.generics;

/**
 * @author sudhir
 *         Date:17/4/17
 *         Time:8:43 PM
 *         Project:core-java-practise
 */
public class PloymorphismTest {

    private static void display(Object integer){
        System.out.println("Object");
    }
    private static void display(int[] integers){
        System.out.println("Integers Array");
    }
    private static void display(String integer){
        System.out.println("String");
    }

    private static void display(Integer integer){
        System.out.println("Integer");
    }
    private static void display(int i){
        System.out.println("int called");
    }


    public static void main(String[] args) {
        //display(null);
       /* Boolean aBoolean=new Boolean(null);
        System.out.println(aBoolean);
        Integer integer=new Integer(null);
        System.out.println(integer);*/

        /*System.out.println(Boolean.valueOf(null));
        System.out.println(Integer.valueOf(null));
        System.out.println(new String());*/


    }
}
