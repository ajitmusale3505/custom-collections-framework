package customCollectionFramewrok.list;

import java.lang.reflect.Array;

public class HashMap<K, V> {

	private class Node {
		K key;
		V value;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private int n;
	private int N;
	private LinkedList<Node> buckets[];

	public HashMap() {
		this.N = 4;
		this.buckets = new LinkedList[4];
		for (int i = 0; i < 4; i++) {
			this.buckets[i] = new LinkedList<>();
		}
	}

	private int hashFunction(K key) {
		int hash = key.hashCode();
		return Math.abs(hash) % 4;
	}

	private int searchInLL(K key, int bucketindex) {
		LinkedList<Node> ll = buckets[bucketindex];

		for (int i = 0; i < ll.size(); i++) {
			if (ll.get(i).key == key) {
				return i;
			}
		}
		return -1;
	}

	private void rehash() {
		LinkedList<Node> oldBuckets[] = buckets;

		buckets = new LinkedList[N * 2];

		for (int i = 0; i < N * 2; i++) {
			buckets[i] = new LinkedList<>();
		}

		for (int i = 0; i < oldBuckets.length; i++) {
			LinkedList<Node> ll = oldBuckets[i];

			for (int j = 0; i < ll.size(); j++) {
				Node node = ll.get(j);
				put(node.key, node.value);
			}
		}
	}

	public void put(K key, V value) {
		int bucketIndx = hashFunction(key);
		int dataIndx = searchInLL(key, bucketIndx);

		if ( dataIndx == -1) { // Key doesn't Exist
			buckets[bucketIndx].add(new Node(key, value));
			n++;
		} else {
			Node node = buckets[bucketIndx].get(dataIndx);
			node.value = value;
		}

		double lambda = (double) n / N;
		if (lambda > 2.0) {
			rehash();
		}
	}

	public boolean containsKey(K key) {
		int bucketIndx = hashFunction(key);
		int dataIndx = searchInLL(key, bucketIndx);

		if (bucketIndx == -1)
			return false;
		else
			return true;

	}

	public V get(K key) {
		int bi = hashFunction(key);
		int di = searchInLL(key, bi);

		if (di == -1) {
			return null;
		} else {
			Node node = buckets[bi].get(di);
			return node.value;
		}
	}

	public V remove(K key) {
		int bi = hashFunction(key);
		int di = searchInLL(key, bi);

		if (di == -1)
			return null;
		else {
			Node node = buckets[bi].remove(di);
			return node.value;
		}
	}

	public ArrayList<K> keySet() {
		ArrayList<K> keys = new ArrayList<>();

		for (int i = 0; i < buckets.length; i++) {
			LinkedList<Node> ll = buckets[i];
			for (int j = 0; j < ll.size(); j++) {
				Node node = ll.get(j);
				keys.add(node.key);
			}
		}

		return keys;
	}

	public boolean isEMpty() {
		return n == 0;
	}
}
