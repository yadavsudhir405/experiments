package github.com.yadavsudhir405.experiments.coreJavaPractise.icollections;

/**
 * @author sudhir
 *         Date:10/4/17
 *         Time:10:59 AM
 *         Project:core-java-practise
 */
public interface Icollection<E> extends Iterable<E> {

    public boolean add(E e);
    public boolean addAll(Icollection<? extends E> elements);

    public void clear();
    public boolean remove(E e);
    public boolean removeAll(Icollection<? extends E> elements);
    public boolean retain(E e);
    public boolean retainsAll(Icollection<? extends E> elements);

    public int size();
    public boolean isEmpty();
    public boolean contains(E e);
    public boolean containsAll(Icollection<? extends E> elemets);
    public Object[] toArray();
    public E[] toArray(E[] array);

}
