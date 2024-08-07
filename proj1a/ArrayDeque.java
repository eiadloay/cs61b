public class ArrayDeque<T> {
    private static final int INIT_CAPACITY = 8;
    private int currCapacity;
    private int size;
    private int first;
    private int last;
    private int numRight, numLeft;
    private T[] elements;

    public ArrayDeque() {
        elements = (T[]) new Object[INIT_CAPACITY];
        currCapacity = INIT_CAPACITY;
        size = 0;
        last = INIT_CAPACITY / 2;
        first = last - 1;
        numLeft = 0;
        numRight = 0;
    }

    
    public void addFirst(T item) {
        if (first == 0) {
            resize();
        }
        elements[first--] = item;
        size++;
        numLeft++;
    }

    
    public void addLast(T item) {
        if (last == currCapacity - 1) {
            resize();
        }
        elements[last++] = item;
        size++;
        numRight++;
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
        size--;
        return elements[++first];
    }

    
    public T removeLast() {
        size--;
        return elements[--last];
    }

    
    public T get(int index) {
        return elements[first + 1 + index];
    }

    private void resize() {
        int newCapacity = currCapacity * 2;
        T[] temp = (T[]) new Object[newCapacity];
        int newLast = newCapacity / 2;
        int newFirst = newLast - 1;
        int oldLast = currCapacity / 2;
        int oldFirst = oldLast - 1;
        for (int i = newFirst; i > newFirst - numLeft; i--) {
            if (i <= 0) {
                break;
            }
            temp[i] = elements[oldFirst--];
        }
        for (int i = newLast; i < newLast + numRight; i++) {
            if (i >= newCapacity) {
                break;
            }
            temp[i] = elements[oldLast++];
        }
        elements = temp;
        first = newFirst - numLeft;
        last = newLast + numRight;
        currCapacity = newCapacity;
    }
}
