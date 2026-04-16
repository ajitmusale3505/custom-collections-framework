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

	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public boolean add(E ele) {
		if (size == 0) {
			Node<E> newNode = new Node(null, ele, null);
			head = newNode;
			tail = newNode;
			size++;
		} else if (size > 0) {
			tail.next = new Node<E>(tail, ele, null);
			tail = tail.next;
			size++;
		}
		return true;
	}

	public void add(int index, E ele) {

		if (index < 0 || index > size)
			throw new MyIndexOutOfBoundsException("Index: " + index + ", Size: " + size);

		if (index == 0) {
			head.prev = new Node(null, ele, head);
			head = head.prev;
			size++;
		} else if (index == size) {
			tail.next = new Node(tail, ele, null);
			tail = tail.next;
			size++;
		} else {
			int trace = 0;
			Node<E> currentNode = head;
			for (int i = 1; i < size; i++) {
				trace++;
				System.out.println("Trace : " + trace);
				currentNode = currentNode.next;
				if (index == trace) {
					Node currPrev = currentNode.prev;
					Node newNode = new Node<E>(currPrev, ele, currentNode);
					currPrev.next = newNode;
					newNode.next = currentNode;
					currentNode.prev = newNode;
					size++;
				}

			}
		}
	}

	public void addFirst(E ele) {
		add(0, ele);
	}

	public void addLast(E ele) {
		add(size, ele);
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

		if (index < 0 || index >= size)
			throw new MyIndexOutOfBoundsException("Index: " + index + ", Size: " + size);

		if (index == 0)
			return (E) head.data;
		if (index == size - 1)
			return (E) tail.data;

		Node curr = head;
		int trace = 0;
		E ele = null;
		while (trace != size) {
			Node next = curr.next;
			if (index == trace) {
				ele = (E) curr.data;
				break;
			}
			trace++;
			curr = next;
		}
		return ele;
	}
	
	public E getFirst() {
		return get(0);
	}
	
	public E getLast() {
		return get(size-1);
	}
	   
	public E element() {
		if(size==0) throw new MyNoSuchElementException("No element found: The collection is empty.");
		return get(0);
	}
	
	public E peek() {
		return getFirst();
	}
	
	public E peekFirst() {
		return getFirst();
	}
	
	public E peekLast() {
		return getLast();
	}

	public int indexof(Object obj) {
		Node curr = head;
		int trace = 0;
		while(trace!=size) {
			Node next = curr.next;
			if (curr.data.equals(obj)) {
				return trace;
			}
			curr = next;
			trace++;
		}
		return -1;
	}
	
	public int lastIndexOf(Object obj) {
		Node curr = tail;
		int trace = size;
		while(trace!=0) {
			Node next = curr.prev;
			if (curr.data.equals(obj)) {
				return trace-1;
			}
			curr = next;
			trace--;
		}
		return -1;
	}
	
	public void clear() {
		Node curr = head;

		while (curr != null) {
			Node next = curr.next;

			curr.prev = null;
			curr.next = null;

			curr = next;
		}

		head = null;
		tail = null;
		size = 0;
	}
	
	public boolean contains(Object obj) {
		return indexof(obj)==-1? false : true;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		Node<E> current = head;

		while (current != null) {
			sb.append(current.data);

			if (current.next != null) {
				sb.append(", ");
			}

			current = current.next;
		}

		sb.append("]");
		return sb.toString();
	}

}
