package customCollectionFramewrok.list;

import customCollectionFramewrok.exception.MyIllegalArgumentException;

public class Stack<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] arr;
    private int size;

    public Stack() {
        arr = new Object[DEFAULT_CAPACITY];
    }

    public Stack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new MyIllegalArgumentException("Capacity must be greater than zero");
        }
        arr = new Object[initialCapacity];
    }

    public boolean empty() {
        return size == 0;
    }

    public E push(E item) {
        ensureCapacity(size + 1);
        arr[size++] = item;
        return item;
    }

    public E pop() {
        if (empty()) {
            return null;
        }
        E item = (E) arr[--size];
        arr[size] = null;
        return item;
    }

    public E peek() {
        return empty() ? null : (E) arr[size - 1];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return arr.length;
    }

    public void clear() {
        while (size > 0) {
            arr[--size] = null;
        }
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
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }

    @Override
    public String toString() {
        if (empty()) {
            return "Stack is Empty";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("TOP\n");
        sb.append("----\n");
        for (int i = size - 1; i >= 0; i--) {
            sb.append(arr[i]).append("\n");
        }
        return sb.append("----").toString();
    }
}