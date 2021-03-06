/**
 * Your implementation of a linked queue.
 *
 * @author Chris Muse
 * @version 1.0
 */
public class LinkedQueue<T> implements QueueInterface<T> {

    // Do not add new instance variables.
    private LinkedNode<T> head;
    private LinkedNode<T> tail;
    private int size;

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is empty");
        }
        if (size == 1) {
            LinkedNode<T> twin = head;
            head = null;
            tail = null;
            size--;
            return twin.getData();
        } else {
            LinkedNode<T> twin = head;
            head = head.getNext();
            size--;
            return twin.getData();
        }
    }

    @Override
    public void enqueue(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("Cannot add a null to"
                    + " the Queue");
        }
        if (isEmpty()) {
            head = new LinkedNode(data);
            tail = head;
            size++;
        } else {
            LinkedNode<T> adder = new LinkedNode<T>(data, null);
            tail.setNext(adder);
            tail = adder;
            size++;
        }
    }

    @Override
    public boolean isEmpty() {
        // DO NOT MODIFY THIS METHOD!
        return size == 0;
    }

    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    /**
     * Returns the head of this queue.
     * Normally, you would not do this, but we need it for grading your work.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the head node
     */
    public LinkedNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail of this queue.
     * Normally, you would not do this, but we need it for grading your work.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the tail node
     */
    public LinkedNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }
}