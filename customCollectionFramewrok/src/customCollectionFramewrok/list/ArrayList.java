package customCollectionFramewrok.list;

import java.util.Iterator;

import customCollectionFramewrok.exception.MyIllegalArgumentException;
import customCollectionFramewrok.exception.MyIndexOutOfBoundsException;

public class ArrayList<E> {

	private static final int DEFAULT_CAPACITY = 10;
	private Object[] elements;
	private int size;

	public ArrayList() {
		this.elements = new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}

	public ArrayList(int initial_Cap) {
		if (initial_Cap < 0) {
			throw new MyIllegalArgumentException("Capacity cannot be negative");
		}
		this.elements = new Object[initial_Cap];
		this.size = 0;
	}

	public void add(E ele) {
		ensureCapacity(size + 1);
		elements[size++] = ele;
	}

	public void addFirst(E ele) {
		Object[] newArr = new Object[size + 1];
		newArr[0] = ele;
		int j = 1;
		for (int i = 0; i < size; i++) {
			newArr[j++] = elements[i];
		}
		elements = newArr;
		size++;
	}

	public void addLast(E ele) {
		Object[] newArr = new Object[size + 1];
		newArr[newArr.length - 1] = ele;
		for (int i = 0; i < size; i++) {
			newArr[i] = elements[i];
		}
		elements = newArr;
		size++;
	}

	public E get(int index) {
		checkIndex(index);
		return (E) elements[index];
	}

	public E remove(int index) {
		checkIndex(index);
		Object ele = elements[index];
		for (int i = index; i < size - 1; i++) {
			elements[i] = elements[i + 1];
		}
		elements[size - 1] = null;
		size--;
		return (E) ele;
	}
	
//	public E removeFirst() {
//		
//	}
	  public E removeLast() {
		  Object[] newArr = new Object[size - 1];
		  Object temp = elements[size-1];
		  elements[size-1]= null;
		  for (int i = 0; i < size-1; i++) {
				newArr[i] = elements[i];
			}
			elements = newArr;
			size--;
		 return (E) temp;
	  }

	public void ensureCapacity(int minCap) {
		if (minCap > elements.length) {
			int newCap = elements.length == 0 ? 1 : elements.length + (elements.length / 2);

			if (newCap < minCap) {
				newCap = minCap;
			}

			Object[] newArr = new Object[newCap];

			for (int i = 0; i < size; i++) {
				newArr[i] = elements[i];
			}
			elements = newArr;
		}
	}

	public void trimToSize() {
		Object[] newArr = new Object[size];

		for (int i = 0; i < size; i++) {
			newArr[i] = elements[i];
		}

		elements = newArr;
	}

	public void checkIndex(int index) {
		if (index < 0 || index >= size)
			throw new MyIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}

	public int size() {
		return size;
	}

	public int capacity() {
		return elements.length;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			sb.append(elements[i]);
			if (i < size - 1)
				sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}

	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	public boolean isEmpty() {
		return size <= 0;
	}

	public boolean contains(Object obj) {
		for (int i = 0; i < size; i++) {
			if (obj == null ? elements[i] == null : obj.equals(elements[i])) {
				return true;
			}
		}
		return false;
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
		if (isEmpty()) {
			throw new MyIllegalArgumentException("Index: " + 0 + ", Size: " + size);
		}
		return (E) elements[0];
	}

	public E getLast() {
		if (isEmpty()) {
			throw new MyIllegalArgumentException("Index: " + (size - 1) + ", Size: " + size);
		}
		return (E) elements[size - 1];
	}

	public E set(int idx, E ele) {
		checkIndex(idx);
		Object temp = elements[idx];
		elements[idx] = ele;
		return (E) temp;
	}
}
