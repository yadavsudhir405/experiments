package github.com.yadavsudhir405.experiments.coreJavaPractise.concurrency;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author sudhir
 *         Date:30/3/17
 *         Time:2:43 PM
 *         Project:core-java-practise
 */
public class Interruption {
    public static void main(String[] args) throws InterruptedException {
            PrimeGenerator primeGenerator=new PrimeGenerator();
            Thread thread=new Thread(primeGenerator,"PrimeGenerator");
            thread.start();
            for(int i=0;i<5;i++){
                System.out.println(primeGenerator.getPrimes());
                TimeUnit.SECONDS.sleep(1);
            }
    }
    private static class PrimeGenerator implements Runnable{
        private final List<BigInteger> primes=new ArrayList<>();
        private volatile boolean isCancelled=false;
        @Override
        public void run() {
            BigInteger prime=BigInteger.ONE;
            while (!isCancelled){
                BigInteger p=prime.nextProbablePrime();
                synchronized (this){
                    primes.add(p);
                }
            }
        }
        public  synchronized List<BigInteger> getPrimes(){
            return new ArrayList<>(primes);
        }
        public void cancel(){
            this.isCancelled=true;
        }
    }
}
