package oracle.test;

import java.util.Queue;

/**
 * Provides waiting thread-safe access to a java.util.Queue instance.
 *
 * Requirements:
 * - Usage of API from java.util.concurrent packageis prohibited.
 * - Limit the amount of additional consumed memory to O(1).
 * - The implementation is supposed to be acceptable for usage in a highly
 * multi-thread environment.
 *
 * Useful tips a.k.a. common pitfalls:
 * - Please note that you do not need to implement java.util.Queue.
 * - Readiness to accept or provide elements is solely dependent on the
 * underlying queue. Any additional queue capacity limitations break contract
 * defined in the javadoc.
 */
public class BlockingQueue<E> {
    private  final Queue<E> queue;
    /**
     * @param queue The underlying "wrapped" queue.
     */
    public BlockingQueue(Queue<E> queue) {
        this.queue=queue;
    }

    /**
     * Inserts the specified element into the underlying queue, waiting if
     * necessary for the underlying queue to be ready to accept new elements.
     * @param e the element to insert.
     */
    public void push(E e) {
        synchronized (queue){
            while (!addIfEnoughSpaceAvailable(e)){
                try {
                    queue.wait();
                } catch (InterruptedException e1) {
                    Thread.currentThread().interrupt();
                }
            }
            queue.notifyAll();
        }

    }
    private  boolean addIfEnoughSpaceAvailable(E e){
        synchronized (queue){
            try{
                return queue.add(e);
            }catch (IllegalStateException e1){
                return false;
            }
        }
    }

    /**
     * Retrieves and removes the head of the underlying queue, waiting if
     * necessary until it is capable of providing an element.
     * @return the retrieved element
     */
    public E pull() {
        synchronized (queue){
            E e=queue.poll();
            while(e==null){
                try {
                    queue.wait();
                } catch (InterruptedException e1) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Interruptd");
                }
                e=queue.poll();
            }
            queue.notifyAll();
            return e;
        }
    }
}