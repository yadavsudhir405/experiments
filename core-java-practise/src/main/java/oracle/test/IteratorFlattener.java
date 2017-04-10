package oracle.test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * "Flattens" nested sub-iterators into an iterator in a depth-first manner.
 *
 * Requirements:
 *  - Limit the amount of additional consumed memory to O(1).
 *
 * Example: an iterator {{1,2},{3},{4,5}} which has three sub-iterators with
 * 2, 1 and 2 elements correspondingly, presents values in this order:
 * {1, 2, 3, 4, 5}
 */
public class IteratorFlattener<E> implements Iterator<E> {
    private final List<E> elements;
    private final Iterator<E> flatterIterator;
    private final Iterator<Iterator<E>> iteratorIterator;
    // implement code here ...
    public IteratorFlattener(Iterator<Iterator<E>> root) {
        this.iteratorIterator=root;
        elements=new CopyOnWriteArrayList<E>();
        populateList(root);
        flatterIterator=elements.iterator();
    }
    private void populateList(Iterator<Iterator<E>> iteratorIterator){
        while(iteratorIterator.hasNext()){
            List<E> subList=(List<E>) iteratorIterator.next();
            Iterator<E> subIterator=subList.iterator();
            while(subIterator.hasNext()){
                elements.add(subIterator.next());
            }
        }
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     *
     * @return {@code true} if the iteration has more elements
     */
    public boolean hasNext() {
       // return iteratorIterator.next()!=null?false:false;
       return flatterIterator.hasNext();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    public E next() {
        return flatterIterator.next();
    }

    /**
     * Removes from the underlying collection the last element returned
     * by this iterator (optional operation). This method can be called
     * only once per call to {@link #next}.
     *
     * @throws IllegalStateException if the {@code next} method has not
     *         yet been called, or the {@code remove} method has already
     *         been called after the last call to the {@code next}
     *         method
     */
    public void remove() {
        Iterator<E> lastSubIterator=null;
        while(iteratorIterator.hasNext()){
            lastSubIterator=iteratorIterator.next();
        }
        while (lastSubIterator.hasNext()){
            E e=lastSubIterator.next();
            elements.remove(e);
        }
    }
}
