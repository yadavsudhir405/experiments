package github.com.yadavsudhir405.experiments.coreJavaPractise.strings;

/**
 * @author sudhir
 *         Date:2/4/17
 *         Time:9:26 AM
 *         Project:core-java-practise
 */
public class StingInitialization {
    public static void main(String[] args) {

//        System.out.println(args instanceof null);
        System.out.println(null instanceof String);

        //boolean a=Boolean.valueOf(null);
        //System.out.println(a);
        //String.valueOf(null);
        //Integer.valueOf(-1);
        //constructorTestString();
        //charTest();
    }
    private static void charTest(){
        String name="0ello\\";
        int i='A';
        System.out.println(i);
    }

    private static void constructorTestString() {
        //Initilizae with empty String
        //passing directly null values are not allowed in the constructor,however below is possible
        //and constructor will throw NullPointerException

        /*String str1=null;
        String str=new String(str1);
        System.out.println();*/
        byte[] bytes=new byte[2];
        bytes[0]=(byte) 0x90;
        bytes[0]=(byte) 0x91;
        String str= new String(bytes);
        System.out.println(str);
    }

}

