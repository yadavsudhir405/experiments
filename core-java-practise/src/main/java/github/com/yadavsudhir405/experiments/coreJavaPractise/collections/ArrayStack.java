package github.com.yadavsudhir405.experiments.coreJavaPractise.collections;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sudhir
 *         Date:10/4/17
 *         Time:2:31 PM
 *         Project:core-java-practise
 */
public class ArrayStack<E> implements Istack<E> {

    private final Deque<E> arrayDeque;

    public ArrayStack() {
        this.arrayDeque = new ArrayDeque<E>();
    }

    public ArrayStack(int capacity){
        this.arrayDeque=new ArrayDeque<E>(capacity);
    }

    @Override
    public void push(E e) {
        boolean added=arrayDeque.offerFirst(e);
        if(!added){
            System.out.println("Stack is Full");
        }
    }

    @Override
    public E pop() {
        return arrayDeque.pollFirst();
    }


    public IIterator<E> iterator(){
        return new IIterator();
    }
    class IIterator<E> implements java.util.Iterator<E>{
        private final java.util.Iterator<E> iterator;

        public IIterator() {
            this.iterator=(java.util.Iterator)arrayDeque.iterator();
        }

        @Override
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override
        public E next() {
            return this.iterator.next();
        }
    }
}
