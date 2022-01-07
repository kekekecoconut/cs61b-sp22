import java.security.Key;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>{

    private int size = 0;

    private class Node{
        private K key;
        private V value;

        private Node left;
        private Node right;
        private int size;

        public Node(K key, V val, int size) {
            this.key = key;
            this.value = val;
            this.size = size;
        }
    }

    @Override
    public void clear() {

    }

    public void printInOrder(){

    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        
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

    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
