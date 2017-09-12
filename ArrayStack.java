/**
 * Your implementation of an array-backed stack.
 *
 * @author Christopher Muse
 * @userid cmuse7
 * @GTID 903104255
 * @version 1.0
 */
public class ArrayStack<T> implements StackInterface<T> {

    // Do not add new instance variables.
    private T[] backingArray;
    private int size;

    /**
     * Constructs a new ArrayStack.
     */
    public ArrayStack() {
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Pop from the stack.
     *
     * Do not shrink the backing array.
     *
     * @see StackInterface#pop()
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Stack is empty");
        }
        size--;
        T store = backingArray[size];
        backingArray[size] = null;
        return store;
    }

    /**
     * Push the given data onto the stack.
     *
     * If sufficient space is not available in the backing array, you should
     * regrow it to double the current length.
     *
     * @see StackInterface#push(T)
     */
    @Override
    public void push(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("Cannot add a null to"
                    + " the Stack");
        }
        if (size == backingArray.length) {
            regrow();
        }
        backingArray[size] = data;
        size++;
    }

    /**
     * Regrows the backing array
     */
    private void regrow() {
        T[] big = (T[]) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            big[i] = backingArray[i];
        }
        backingArray = big;
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
     * Returns the backing array of this stack.
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
