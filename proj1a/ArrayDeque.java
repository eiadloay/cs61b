public class ArrayDeque<T> implements Deque<T> {
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

    @Override
    public void addFirst(T item) {
        if(first == 0)
            resize();
        elements[first--] = item;
        numLeft++;
    }

    @Override
    public void addLast(T item) {
        if(last == currCapacity - 1)
            resize();
        elements[last++] = item;
        numRight++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (T item : elements) {
            System.out.print(item + " ");
        }
    }

    @Override
    public T removeFirst() {
        T temp = elements[++first];
        elements[first] = null;
        return temp;
    }

    @Override
    public T removeLast() {
        T temp = elements[--last];
        elements[last] = null;
        return temp;
    }

    @Override
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
        for(int i = newFirst; i > newFirst - numLeft; i--) {
            temp[i] = elements[oldFirst--];
        }
        for(int i = newLast; i > newLast + numRight; i++) {
            temp[i] = elements[oldLast++];
        }
        elements = temp;
        first = newFirst - numLeft;
        last = newLast + numRight;
        currCapacity = newCapacity;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addFirst(1);
        arr.addFirst(2);
        arr.addFirst(3);
        arr.addFirst(4);
        arr.addFirst(5);
    }
}
