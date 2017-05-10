package github.com.yadavsudhir405.experiments.coreJavaPractise.concurrency.concurrentExecution;

/**
 * @author sudhir
 *         Date:10/5/17
 *         Time:12:01 PM
 *         Project:core-java-practise
 */
@FunctionalInterface
public interface IExecuter {
    void execute(Runnable task);
}
