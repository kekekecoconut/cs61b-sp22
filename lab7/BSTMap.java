import java.security.Key;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>{

    private int size = 0;

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    private class Node{
        private K key;
        private V value;

        private Node left;
        private Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private Node root;

    @Override
    public void clear() {

        root = null;
        size = 0;

    }


    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("calls containsKey() with a null key");
        }

        if (get(key) == null)
            return false;

        return true;
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    public V get(Node node, K key){
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);

        if (cmp < 0)
            return get(node.left, key);
        else if (cmp > 0)
            return get(node.right, key);

        return node.value;
    }



    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {

        if (key == null) {
            throw new IllegalArgumentException("calls put() with a null key");
        }
        root = put(root, key, value);
        size++;

    }

    public Node put(Node node, K key, V value) {

        if (node == null)
            return new Node(key, value);
        int cmp = key.compareTo(node.key);

        if (cmp < 0)
            node.left = put(node.left, key,value);
        else if (cmp > 0)
            node.right = put(node.right, key, value);
        else
        {
            node.value = value;
            size--;
        }

        return node;

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V remove(K key, V value) {
        return null;
    }

    public static void main(String[] args) {
        BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        for (int i = 0; i < 200; i++) {
            b.put("hi" + i, 1+i);

        }
        System.out.println(b.get("hi199"));
    }
}
