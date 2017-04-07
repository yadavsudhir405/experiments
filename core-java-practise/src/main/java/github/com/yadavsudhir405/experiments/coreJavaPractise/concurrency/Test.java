package github.com.yadavsudhir405.experiments.coreJavaPractise.concurrency;

/**
 * @author sudhir
 *         Date:6/4/17
 *         Time:4:08 PM
 *         Project:core-java-practise
 */
public class Test {

    public  static void main(String[] args) {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                pong();
            }
        });
        t.start();
        while(true){
            synchronized (Test.class){
                System.out.println("ping");
            }
        }

    }
    public  static void pong(){

           while (true){
               synchronized (Test.class) {
                   System.out.println("pong");
               }

           }


    }
}
