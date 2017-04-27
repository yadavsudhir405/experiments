package github.com.yadavsudhir405.experiments.coreJavaPractise.algos;

/**
 * @author sudhir
 *         Date:27/4/17
 *         Time:10:09 AM
 *         Project:core-java-practise
 */
@FunctionalInterface
public interface IIntConsumer {
    void accept(int value);


    default IIntConsumer andThen(IIntConsumer after){
        return (x)->{accept(x);after.accept(x);};
    }
}
