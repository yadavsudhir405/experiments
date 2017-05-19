package github.com.yadavsudhir405.experiments.coreJavaPractise.concurrency.concurrentExecution;

/**
 * @author sudhir
 *         Date:10/5/17
 *         Time:12:02 PM
 *         Project:core-java-practise
 */
public interface IExecuterService extends IExecuter {
    void shutdown();
    void shutdownNow();
    void shutdownNow(boolean mayInterrupting);
    <V> IFuture<V> submit(ICallable<V> task);

}
