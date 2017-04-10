package github.com.yadavsudhir405.experiments.coreJavaPractise.icollections;

/**
 * @author sudhir
 *         Date:10/4/17
 *         Time:11:35 AM
 *         Project:core-java-practise
 */
public interface Iqueue<E> extends Icollection<E> {
    public boolean offer(E element);
    public E poll();
    public E peek();

    public boolean add(E e) throws IllegalArgumentException,IllegalStateException,NullPointerException,ClassCastException;
    public E remove();
    public E element();
}
