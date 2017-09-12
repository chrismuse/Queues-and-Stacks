/**
 * Your implementation of an array-backed queue.
 *
 * @author Christopher Muse
 * @version 1.0
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    // Do not add new instance variables.
    private T[] backingArray;
    private int front;
    private int back;
    private int size;

    /**
     * Constructs a new ArrayQueue.
     */
    public ArrayQueue() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Dequeue from the front of the queue.
     *
     * Do not shrink the backing array.
     * If the queue becomes empty as a result of this call, you must not
     * explicitly reset front or back to 0.
     *
     * @see QueueInterface#dequeue()
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is empty");
        }
        T store = backingArray[front];
        backingArray[front] = null;
        front++;
        if (front >= backingArray.length) {
            front = 0;
        }
        size--;
        return store;
    }

    /**
     * Add the given data to the queue.
     *
     * If sufficient space is not available in the backing array, you should
     * regrow it to double the current length. If a regrow is necessary,
     * you should copy elements to the front of the new array and reset
     * front to 0.
     *
     * @see QueueInterface#enqueue(T)
     */
    @Override
    public void enqueue(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("Cannot add a null to"
                    + " the Queue");
        }
        if (size == backingArray.length) {
            regrow();
        }
        backingArray[back] = data;
        back = (back + 1) % backingArray.length;
        size++;
    }

    /**
     * Regrows the backing array
     */
    private void regrow() {
        T[] bigger = (T[]) new Object[size * 2];
        for (int i = 0; i < backingArray.length; i++) {
            bigger[i] = backingArray[front % size];
            front++;
        }
        backingArray = bigger;
        front = 0;
        back = size;
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
     * Returns the backing array of this queue.
     * Normally, you would not do this, but we need it for grading your work.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the backing array
     */
    public Object[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }
}