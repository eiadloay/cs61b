public class LinkedListDeque<T> {
    private Node<T> first;
    private Node<T> last;

    private int size;

    public LinkedListDeque() {
        first = new Node<T>();
        last = first;
        size = 0;
    }

    
    public void addFirst(T item) {
        if (size == 0) {
            first = new Node<>(item);
            last = first;
        } else {
            Node<T> temp = new Node<>(item);
            temp.next = first;
            first.prev = temp;
            first = temp;
        }
        size++;
    }

    
    public void addLast(T item) {
        if (size == 0) {
            last = new Node<>(item);
            first = last;
        } else {
            Node<T> temp = new Node<>(item);
            last.next = temp;
            temp.prev = last;
            last = temp;
        }
        size++;
    }

    
    public boolean isEmpty() {
        return size == 0;
    }

    
    public int size() {
        return size;
    }

    
    public void printDeque() {
        Node<T> curr = first;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T val = first.val;
        if (first == last) {
            first = null;
            last = null;
        } else {
            Node<T> temp = first.next;
            first = null;
            first = temp;
        }
        size--;
        return val;
    }

    
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T val = last.val;

        if (last == first) {
            first = null;
            last = null;
        } else {
            Node<T> temp = last.prev;
            last = null;
            last = temp;
        }
        size--;
        return val;
    }

    
    public T get(int index) {
        if (index > size - 1) {
            return null;
        }

        Node<T> curr = first;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    public T getRecursive(int index) {
        Node<T> curr = first;
        return getHelper(curr, index);
    }

    private T getHelper(Node<T> curr, int index) {
        if (index == 0) {
            return curr.val;
        }
        return getHelper(curr.next, --index);
    }

    private static class Node<T> {
        T val;
        Node<T> next;
        Node<T> prev;

        Node() {
            val = null;
            next = null;
            prev = null;
        }

        Node(T val) {
            this.val = val;
            this.next = null;
            prev = null;
        }
    }
}
