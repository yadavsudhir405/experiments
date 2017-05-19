package github.com.yadavsudhir405.experiments.coreJavaPractise.concurrency.concurrentExecution;

import java.util.concurrent.TimeUnit;

/**
 * @author sudhir
 *         Date:10/5/17
 *         Time:1:07 PM
 *         Project:core-java-practise
 */
public class IFutureTask<V> implements IRunnableIFuture<V> {


    @Override
    public Object get() throws InterruptedException {
        return null;
    }

    @Override
    public Object get(long val, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public Object cancel(boolean mayInterrupting) {
        return null;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void run() {

    }
}
