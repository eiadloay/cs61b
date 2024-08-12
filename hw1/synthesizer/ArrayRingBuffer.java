package synthesizer;

import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last++] = x;
        if (last >= capacity) {
            last = 0;
        }
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T temp = rb[first++];
        if (first >= capacity) {
            first = 0;
        }
        fillCount--;
        return temp;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer is empty");
        }
        return rb[first];
    }

    private class ARBIterator implements Iterator<T> {
        int ptr = first;
        int num = 0;
        @Override
        public boolean hasNext() {
            return num < fillCount;
        }

        @Override
        public T next() {
            T temp = rb[ptr];
            ptr++;
            if (ptr == capacity) {
                ptr = 0;
            }
            num++;
            return temp;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ARBIterator();
    }
}
