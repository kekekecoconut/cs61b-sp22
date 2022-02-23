
import java.util.*;

public class MyHashMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private int initialSize = 16;

    private double loadFactor = 0.75;

    private int threshold; //size

    private int size;

    private Entry<K, V>[] tables;


    static class Entry<K,V> implements Map.Entry<K, V>{

        public K key;

        public V value;

        public int hash;

        Entry<K, V> next;


        public Entry(K key, V value, int hash, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        public Entry() {

        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            return value;
        }
    }

    public void resize(int newSize) {
        initialSize = newSize;
        threshold = (int) (newSize * loadFactor);
        Entry<K, V>[] newTables = new Entry[newSize];
        for (int i = 0; i < tables.length; i++) {
            for (Entry<K, V> e = tables[i]; e != null; e = e.next) {

                addEntry(hash(e.key, newSize), e.key, e.value, newTables);

            }
        }

        tables = newTables;
    }



    public void addEntry(int hash, K key, V value, Entry<K, V>[] newTables) {
        Entry<K, V> e = newTables[hash];
        newTables[hash] = new Entry<>(key, value, hash, e);
    }

    public Entry<K, V> removeEntry(K key) {

        if (size==0)
            return null;
        Entry<K, V> prev = tables[hash(key)];
        Entry<K, V> e = prev;
        while (e!=null) {
            Entry<K, V> next = e.next;
            if (e.key==key || (key!=null && key.equals(e.key))) {
                size--;
                if (prev==e)
                    tables[hash(key)] = next;
                else
                    prev.next = next;
                return e;
            }
            prev = e;
            e = next;
        }

        return e;
    }


    public void addEntry(int hash, K key, V value) {

        Entry<K, V> e = tables[hash];
        tables[hash] = new Entry<>(key, value, hash, e);

    //    System.out.println("now:"+tables[hash].key+" "+tables[hash].value);
        if (size >= threshold) {
            resize(2 * initialSize);
        }
    }



    public MyHashMap(int initialSize, double loadFactor) {
        this.size = 0;
        this.initialSize = initialSize;
        this.loadFactor = loadFactor;

        this.threshold = (int) (initialSize * loadFactor);
        tables = new Entry[initialSize];
    }

    public MyHashMap(int initialSize) {
        this.size = 0;
        this.initialSize = initialSize;

        this.threshold = (int) (initialSize * loadFactor);
        tables = new Entry[initialSize];
    }

    public MyHashMap() {

        this.size = 0;
        int initialSize = 16;
        this.threshold = (int) (initialSize * loadFactor);
        tables = new Entry[initialSize];
    }

    public int hash(K key, int ns){
        if (key == null)
            return 0;

        return Math.floorMod(key.hashCode(), ns);
    }

    public int hash(K key){
        if (key == null)
            return 0;

        //System.out.println("initialSize;"+initialSize);
        return Math.floorMod(key.hashCode(), initialSize);
    }

    @Override
    public void clear() {

        this.size = 0;
        for (int i = 0; i < tables.length; i++) {
            tables[i] = new Entry<>();
        }
    }



    @Override
    public boolean containsKey(K key) {
     //   System.out.println("key: "+key);
    //    System.out.println("value:  "+get(key));
        if (get(key)==null){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public V get(K key) {

        if (key != null) {
        //    System.out.println("hash:"+hash(key)+"\n");
            for (Entry<K, V> e = tables[hash(key)]; e != null ; e = e.next) {
            //    System.out.println("e.key: "+e.key);
            //    System.out.println("e.value: "+e.value);
                if (e.key==null)
                    return null;
                if (e.key.equals(key))
                    return e.value;
            }
        } else {
            for (Entry<K, V> e = tables[0]; e != null ; e = e.next) {
                if (e.key.equals(null))
                    return e.value;
            }
        }

        return null;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        if (!containsKey(key))
            size++;

        if (key == null){
            for (Entry<K, V> e = tables[0]; e != null; e = e.next) {
                if (e.key == null) {
                    tables[0].value=value;
                }
            }


            addEntry(0, key, value);
        }

    //    System.out.println("key:"+key);
        addEntry(hash(key), key, value);
    }

    @Override
    public Set<K> keySet() {
        Set<K> kSet = new HashSet<>();
        for (int i = 0; i < tables.length; i++) {
            for (Entry<K, V> e = tables[i]; e != null; e = e.next) {
                kSet.add(e.key);
            }
        }
        return kSet;
    }

    @Override
    public V remove(K key) {

        Entry<K, V> removeEntry = removeEntry(key);
        return removeEntry==null?null:removeEntry.value;
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }


    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }
}
