package customCollectionFramewrok.list;

public class HashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 4;
    private static final double LOAD_FACTOR = 0.75;

    private class Node {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int n;
    private int capacity;
    private LinkedList<Node>[] buckets;

    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    public HashMap(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }
        capacity = initialCapacity;
        buckets = createBuckets(capacity);
    }

    private LinkedList<Node>[] createBuckets(int capacity) {
        LinkedList<Node>[] result = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            result[i] = new LinkedList<>();
        }
        return result;
    }

    private int hashFunction(K key) {
        int hash = key == null ? 0 : key.hashCode();
        return (hash & 0x7fffffff) % capacity;
    }

    private int searchInLL(K key, int bucketIndex) {
        LinkedList<Node> list = buckets[bucketIndex];
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            if (key == null ? node.key == null : key.equals(node.key)) {
                return i;
            }
        }
        return -1;
    }

    private void rehash() {
        LinkedList<Node>[] oldBuckets = buckets;
        capacity *= 2;
        buckets = createBuckets(capacity);
        int oldSize = n;
        n = 0;

        for (LinkedList<Node> list : oldBuckets) {
            for (int i = 0; i < list.size(); i++) {
                Node node = list.get(i);
                put(node.key, node.value);
            }
        }

        n = oldSize;
    }

    public void put(K key, V value) {
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInLL(key, bucketIndex);

        if (dataIndex == -1) {
            buckets[bucketIndex].add(new Node(key, value));
            n++;
            if ((double) n / capacity > LOAD_FACTOR) {
                rehash();
            }
        } else {
            buckets[bucketIndex].get(dataIndex).value = value;
        }
    }

    public boolean containsKey(K key) {
        int bucketIndex = hashFunction(key);
        return searchInLL(key, bucketIndex) != -1;
    }

    public V get(K key) {
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInLL(key, bucketIndex);
        return dataIndex == -1 ? null : buckets[bucketIndex].get(dataIndex).value;
    }

    public V remove(K key) {
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInLL(key, bucketIndex);
        if (dataIndex == -1) {
            return null;
        }
        n--;
        return buckets[bucketIndex].remove(dataIndex).value;
    }

    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>(n);
        for (LinkedList<Node> list : buckets) {
            for (int i = 0; i < list.size(); i++) {
                keys.add(list.get(i).key);
            }
        }
        return keys;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void clear() {
        buckets = createBuckets(capacity);
        n = 0;
    }
}