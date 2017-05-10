package github.com.yadavsudhir405.experiments.coreJavaPractise.concurrency.concurrentExecution;

import java.util.concurrent.TimeUnit;

/**
 * @author sudhir
 *         Date:10/5/17
 *         Time:12:04 PM
 *         Project:core-java-practise
 */
public interface IFuture<V> {

    V get()throws InterruptedException;
    V get(long val, TimeUnit unit) throws InterruptedException;
    V cancel(boolean mayInterrupting);

}
