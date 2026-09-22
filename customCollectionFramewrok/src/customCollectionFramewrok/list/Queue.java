package customCollectionFramewrok.list;

import customCollectionFramewrok.exception.MyIllegalArgumentException;
import customCollectionFramewrok.exception.MyNoSuchElementException;

public class Queue<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] arr;
    private int front;
    private int size;

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    public Queue(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new MyIllegalArgumentException("Capacity must be greater than zero");
        }
        arr = new Object[initialCapacity];
    }

    public boolean add(E element) {
        ensureCapacity(size + 1);
        arr[(front + size) % arr.length] = element;
        size++;
        return true;
    }

    public boolean offer(E element) {
        return add(element);
    }

    public E remove() {
        if (size == 0) {
            throw new MyNoSuchElementException("Queue is empty");
        }
        E element = (E) arr[front];
        arr[front] = null;
        front = (front + 1) % arr.length;
        size--;
        if (size == 0) {
            front = 0;
        }
        return element;
    }

    public E poll() {
        return size == 0 ? null : remove();
    }

    public E element() {
        if (size == 0) {
            throw new MyNoSuchElementException("Queue is empty");
        }
        return (E) arr[front];
    }

    public E peek() {
        return size == 0 ? null : (E) arr[front];
    }

    public E getFirst() {
        return element();
    }

    public E getLast() {
        if (size == 0) {
            throw new MyNoSuchElementException("Queue is empty");
        }
        return (E) arr[(front + size - 1) % arr.length];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int capacity() {
        return arr.length;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[(front + i) % arr.length] = null;
        }
        front = 0;
        size = 0;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity <= arr.length) {
            return;
        }
        int newCapacity = arr.length + arr.length / 2;
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        Object[] newArr = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[(front + i) % arr.length];
        }
        arr = newArr;
        front = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(arr[(front + i) % arr.length]);
        }
        return sb.append("]").toString();
    }
}