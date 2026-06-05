package customCollectionFramewrok.queue;

public class PriorityQueue<E extends Comparable<E>> {

	private int r;
	private int l;
	private int index;
	private Object[] arr;
	private final int size = 11;
	private int length;

	public PriorityQueue() {
		length = 11;
		arr = new Object[size];
	}

	public PriorityQueue(int size) {
		length = size;
		arr = new Object[size];
	}

	public boolean add(E ele) {
		if (length >= arr.length) {
			grow();
		}

		arr[index] = ele;

		heapifyUp(index);

		index++;

		return true;
	}

	public void grow() {

	}

	private void heapifyUp(int child) {
		while (child > 0) {
			int parent = (child - 1) / 2;

			E childValue = (E) arr[child];
			E parentValue = (E) arr[parent];

			if (childValue.compareTo(parentValue) < 0) {
				swap(child, parent);

				child = parent;
			} else {
				break;
			}
		}
	}

	private void swap(int a, int b) {
		Object temp = arr[a];

		arr[a] = arr[b];

		arr[b] = temp;
	}

	public boolean isFull() {
		return index == length;
	}

	@Override
	public String toString() {
		if (index == 0) {
			return "[]";
		}

		String str = "[";

		for (int i = 0; i < index; i++) {
			str += arr[i];

			if (i != index - 1) {
				str += ", ";
			}
		}

		str += "]";

		return str;
	}
}
