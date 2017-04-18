package github.com.yadavsudhir405.experiments.coreJavaPractise.generals;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

/**
 * @author sudhir
 *         Date:12/4/17
 *         Time:11:19 PM
 *         Project:core-java-practise
 */
public class SystemPrint {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Task(System.out));
        thread.start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Hello World!!!");
    }

    private static class Task implements Runnable{

        private final OutputStream inputStream;

        private Task(OutputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public void run() {
            while (true){
                    try {
                        inputStream.write(7);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            }
        }
    }
}
