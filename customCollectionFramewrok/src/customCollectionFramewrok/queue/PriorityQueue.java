package customCollectionFramewrok.queue;

import customCollectionFramewrok.exception.MyIllegalArgumentException;
import customCollectionFramewrok.exception.MyNoSuchElementException;

public class PriorityQueue<E extends Comparable<E>> {

    private static final int DEFAULT_CAPACITY = 11;
    private Object[] arr;
    private int index;

    public PriorityQueue() {
        this(DEFAULT_CAPACITY);
    }

    public PriorityQueue(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new MyIllegalArgumentException("Capacity must be greater than zero");
        }
        arr = new Object[initialCapacity];
    }

    public boolean add(E ele) {
        ensureCapacity(index + 1);
        arr[index] = ele;
        heapifyUp(index);
        index++;
        return true;
    }

    public boolean offer(E ele) {
        return add(ele);
    }

    public E peek() {
        return index == 0 ? null : (E) arr[0];
    }

    public E element() {
        if (index == 0) {
            throw new MyNoSuchElementException("Priority queue is empty");
        }
        return (E) arr[0];
    }

    public E poll() {
        if (index == 0) {
            return null;
        }
        E result = (E) arr[0];
        index--;
        if (index == 0) {
            arr[0] = null;
            return result;
        }
        arr[0] = arr[index];
        arr[index] = null;
        heapifyDown(0);
        return result;
    }

    public E remove() {
        if (index == 0) {
            throw new MyNoSuchElementException("Priority queue is empty");
        }
        return poll();
    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public int capacity() {
        return arr.length;
    }

    public boolean isFull() {
        return index == arr.length;
    }

    public void clear() {
        for (int i = 0; i < index; i++) {
            arr[i] = null;
        }
        index = 0;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity <= arr.length) {
            return;
        }
        grow(minCapacity);
    }

    private void grow(int minCapacity) {
        int newCapacity = arr.length + arr.length / 2;
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        Object[] newArr = new Object[newCapacity];
        System.arraycopy(arr, 0, newArr, 0, index);
        arr = newArr;
    }

    private void heapifyUp(int child) {
        while (child > 0) {
            int parent = (child - 1) / 2;
            E childValue = (E) arr[child];
            E parentValue = (E) arr[parent];

            if (childValue.compareTo(parentValue) >= 0) {
                break;
            }
            swap(child, parent);
            child = parent;
        }
    }

    private void heapifyDown(int parent) {
        while (true) {
            int left = parent * 2 + 1;
            int right = left + 1;
            int smallest = parent;

            if (left < index && ((E) arr[left]).compareTo((E) arr[smallest]) < 0) {
                smallest = left;
            }
            if (right < index && ((E) arr[right]).compareTo((E) arr[smallest]) < 0) {
                smallest = right;
            }
            if (smallest == parent) {
                break;
            }
            swap(parent, smallest);
            parent = smallest;
        }
    }

    private void swap(int a, int b) {
        Object temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < index; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(arr[i]);
        }
        return sb.append("]").toString();
    }
}