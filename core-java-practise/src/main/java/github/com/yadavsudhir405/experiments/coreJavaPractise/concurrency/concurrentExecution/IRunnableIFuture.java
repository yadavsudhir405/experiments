package github.com.yadavsudhir405.experiments.coreJavaPractise.concurrency.concurrentExecution;

/**
 * @author sudhir
 *         Date:10/5/17
 *         Time:1:06 PM
 *         Project:core-java-practise
 */
public interface IRunnableIFuture<V> extends IRunnable,IFuture {

    public void run();
}
