package customCollectionFramewrok.list;

public class Stack<E> {

	private Object[] arr;
	private int indx = 0;
	private int size;
	private int top = -1;
	private int initialSize = 10;

	public Stack() {
		arr = new Object[initialSize];
	}

	boolean empty() {
		return size == 0;
	}

	public E push(E item) {
		arr[indx++] = item;
		size++;
		top = indx;
		return item;
	}

	public E pop() {

		if (empty()) {
			return null;
		}
		top = indx - 1;
		arr[indx] = null;
		size--;
		indx--;
		return (E) arr[top];
	}

	public E peek() {
		if (empty()) {
			return null;
		}
		return (E) arr[top-1];
	}

	@Override
	public String toString() {

		if (empty()) {
			return "Stack is Empty";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("TOP\n");
		sb.append("----\n");

		for (int i = indx - 1; i >= 0; i--) {
			sb.append(arr[i]).append("\n");
		}

		sb.append("----");

		return sb.toString();
	}
}
