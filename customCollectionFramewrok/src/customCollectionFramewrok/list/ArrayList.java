package customCollectionFramewrok.list;

import customCollectionFramewrok.exception.MyIllegalArgumentException;
import customCollectionFramewrok.exception.MyIndexOutOfBoundsException;

public class ArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public ArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int initialCap) {
        if (initialCap < 0) {
            throw new MyIllegalArgumentException("Capacity cannot be negative");
        }
        this.elements = new Object[initialCap];
    }

    public void add(E ele) {
        ensureCapacity(size + 1);
        elements[size++] = ele;
    }

    public void addFirst(E ele) {
        add(0, ele);
    }

    public void addLast(E ele) {
        add(ele);
    }

    public void add(int index, E ele) {
        if (index < 0 || index > size) {
            throw new MyIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = ele;
        size++;
    }

    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    public E remove(int index) {
        checkIndex(index);
        E element = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return element;
    }

    public E removeFirst() {
        checkNotEmpty();
        return remove(0);
    }

    public E removeLast() {
        checkNotEmpty();
        return remove(size - 1);
    }

    public void ensureCapacity(int minCap) {
        if (minCap <= elements.length) {
            return;
        }
        int newCap = elements.length == 0 ? 1 : elements.length + elements.length / 2;
        if (newCap < minCap) {
            newCap = minCap;
        }
        Object[] newArr = new Object[newCap];
        System.arraycopy(elements, 0, newArr, 0, size);
        elements = newArr;
    }

    public void trimToSize() {
        if (elements.length != size) {
            Object[] newArr = new Object[size];
            System.arraycopy(elements, 0, newArr, 0, size);
            elements = newArr;
        }
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new MyIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkNotEmpty() {
        if (size == 0) {
            throw new MyIllegalArgumentException("Collection is empty");
        }
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return elements.length;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj == null ? elements[i] == null : obj.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        for (int i = size - 1; i >= 0; i--) {
            if (obj == null ? elements[i] == null : obj.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public E getFirst() {
        checkNotEmpty();
        return (E) elements[0];
    }

    public E getLast() {
        checkNotEmpty();
        return (E) elements[size - 1];
    }

    public E set(int idx, E ele) {
        checkIndex(idx);
        E old = (E) elements[idx];
        elements[idx] = ele;
        return old;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(elements[i]);
        }
        return sb.append("]").toString();
    }
}