public class ArrayDeque<T> {
    private static final int INIT_CAPACITY = 8;
    private int currCapacity;
    private int size;
    private int first;
    private int last;
    private T[] elements;

    public ArrayDeque() {
        elements = (T[]) new Object[INIT_CAPACITY];
        currCapacity = INIT_CAPACITY;
        size = 0;
        last = INIT_CAPACITY / 2;
        first = last;
    }

    
    public void addFirst(T item) {
        if (first == 0) {
            resize(currCapacity * 2);
        }
        if (first == last) {
            last++;
        }
        elements[first--] = item;
        size++;
    }

    
    public void addLast(T item) {
        if (last == currCapacity - 1) {
            resize(currCapacity * 2);
        }
        if (last == first) {
            first--;
        }
        elements[last++] = item;
        size++;
    }

    
    public boolean isEmpty() {
        return size == 0;
    }

    
    public int size() {
        return size;
    }

    
    public void printDeque() {
        for (T item : elements) {
            System.out.print(item + " ");
        }
    }

    
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (size < currCapacity / 4) {
            resize(currCapacity / 2);
        }
        size--;
        return elements[++first];
    }

    
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (size < currCapacity / 4) {
            resize(currCapacity / 2);
        }
        size--;
        return elements[--last];
    }

    
    public T get(int index) {
        return elements[first + 1 + index];
    }

    private void resize(int size) {
        int newCapacity = size;
        int oldFirst = first;
        int oldLast = last;
        int oldSize = size;
        T[] temp = (T[]) new Object[currCapacity];
        System.arraycopy(elements, 0, temp, 0, currCapacity);
        elements = (T[]) new Object[newCapacity];
        first = newCapacity / 2;
        last = first;
        for (int i = oldFirst + 1; i < oldLast; i++) {
            addLast(temp[i]);
        }
        currCapacity = newCapacity;
        size = oldSize;
    }
}
