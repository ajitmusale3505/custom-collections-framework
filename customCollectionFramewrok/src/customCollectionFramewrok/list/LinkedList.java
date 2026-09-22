package customCollectionFramewrok.list;

import customCollectionFramewrok.exception.MyIndexOutOfBoundsException;
import customCollectionFramewrok.exception.MyNoSuchElementException;

public class LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E data, Node<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    public boolean add(E ele) {
        linkLast(ele);
        return true;
    }

    public void add(int index, E ele) {
        if (index < 0 || index > size) {
            throw new MyIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == size) {
            linkLast(ele);
        } else if (index == 0) {
            linkFirst(ele);
        } else {
            Node<E> current = node(index);
            Node<E> previous = current.prev;
            Node<E> newNode = new Node<>(previous, ele, current);
            previous.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    public void addFirst(E ele) {
        linkFirst(ele);
    }

    public void addLast(E ele) {
        linkLast(ele);
    }

    public boolean offer(E e) {
        addLast(e);
        return true;
    }

    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    public E get(int index) {
        checkIndex(index);
        return node(index).data;
    }

    public E getFirst() {
        if (size == 0) {
            throw new MyNoSuchElementException("List is empty");
        }
        return head.data;
    }

    public E getLast() {
        if (size == 0) {
            throw new MyNoSuchElementException("List is empty");
        }
        return tail.data;
    }

    public E element() {
        return getFirst();
    }

    public E peek() {
        return size == 0 ? null : head.data;
    }

    public E peekFirst() {
        return peek();
    }

    public E peekLast() {
        return size == 0 ? null : tail.data;
    }

    public E poll() {
        return size == 0 ? null : removeFirst();
    }

    public E pollFirst() {
        return poll();
    }

    public E pollLast() {
        return size == 0 ? null : removeLast();
    }

    public E set(int index, E element) {
        checkIndex(index);
        Node<E> current = node(index);
        E old = current.data;
        current.data = element;
        return old;
    }

    public E remove(int index) {
        checkIndex(index);
        return unlink(node(index));
    }

    public boolean remove(Object obj) {
        Node<E> current = head;
        while (current != null) {
            if (obj == null ? current.data == null : obj.equals(current.data)) {
                unlink(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E removeFirst() {
        if (size == 0) {
            throw new MyNoSuchElementException("List is empty");
        }
        return unlink(head);
    }

    public boolean removeFirstOccurence(Object obj) {
        return remove(obj);
    }

    public E removeLast() {
        if (size == 0) {
            throw new MyNoSuchElementException("List is empty");
        }
        return unlink(tail);
    }

    public boolean removeLastOccurrence(Object obj) {
        Node<E> current = tail;
        while (current != null) {
            if (obj == null ? current.data == null : obj.equals(current.data)) {
                unlink(current);
                return true;
            }
            current = current.prev;
        }
        return false;
    }

    public int indexof(Object obj) {
        int index = 0;
        Node<E> current = head;
        while (current != null) {
            if (obj == null ? current.data == null : obj.equals(current.data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public int indexOf(Object obj) {
        return indexof(obj);
    }

    public int lastIndexOf(Object obj) {
        int index = size - 1;
        Node<E> current = tail;
        while (current != null) {
            if (obj == null ? current.data == null : obj.equals(current.data)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    public void clear() {
        Node<E> current = head;
        while (current != null) {
            Node<E> next = current.next;
            current.prev = null;
            current.next = null;
            current = next;
        }
        head = null;
        tail = null;
        size = 0;
    }

    public boolean contains(Object obj) {
        return indexof(obj) >= 0;
    }

    public int size() {
        return size;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new MyIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void linkFirst(E element) {
        Node<E> oldHead = head;
        Node<E> newNode = new Node<>(null, element, oldHead);
        head = newNode;
        if (oldHead == null) {
            tail = newNode;
        } else {
            oldHead.prev = newNode;
        }
        size++;
    }

    private void linkLast(E element) {
        Node<E> oldTail = tail;
        Node<E> newNode = new Node<>(oldTail, element, null);
        tail = newNode;
        if (oldTail == null) {
            head = newNode;
        } else {
            oldTail.next = newNode;
        }
        size++;
    }

    private E unlink(Node<E> node) {
        Node<E> previous = node.prev;
        Node<E> next = node.next;

        if (previous == null) {
            head = next;
        } else {
            previous.next = next;
        }

        if (next == null) {
            tail = previous;
        } else {
            next.prev = previous;
        }

        E data = node.data;
        node.data = null;
        node.prev = null;
        node.next = null;
        size--;
        return data;
    }

    private Node<E> node(int index) {
        if (index < size / 2) {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }

        Node<E> current = tail;
        for (int i = size - 1; i > index; i--) {
            current = current.prev;
        }
        return current;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            if (current != head) {
                sb.append(", ");
            }
            sb.append(current.data);
            current = current.next;
        }
        return sb.append("]").toString();
    }
}