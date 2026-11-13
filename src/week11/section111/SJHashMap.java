/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week11.section111;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class SJHashMap<K, V> implements Map<K, V> {
    private static class Entry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }

        @Override
        public V setValue(V value) {
            return null;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) {
                return true;
            }
//            if(o == null) {
//                return false;
//            }
//            if(!(o instanceof Map.Entry<?, ?>)) {
//                return false;
//            }
            if(!(o instanceof Map.Entry<?, ?> that)) {
                return false;
            }

            return Objects.equals(this.key, that.getKey()) &&
                    Objects.equals(this.value, that.getValue());
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
//            return key.hashCode() ^ value.hashCode();
        }


        @Override
        public String toString() {
            return key + " " + value;
        }
    }

    private static final int STARTING_CAPACITY = 10;
    private static final double LOAD_THRESHOLD = 0.8;
    private static final Entry DELETED = new Entry<>(null, null);

    private Entry<K, V>[] entries;
    private int numKeys;
    private int numDeleted;

    public SJHashMap() {
        entries = new Entry[STARTING_CAPACITY];
        numKeys = 0;
        numDeleted = 0;
    }


    @Override
    public int size() {
        return numKeys;
    }

    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    @Override
    public boolean containsKey(Object key) { //O(1)
        // get index
        int index = findIndex(key);
        // look if in index
        while(entries[index] != null) {
            if(Objects.equals(key, entries[index].key)) {
                // found it
                return true;
            }
            index = (index + 1) % entries.length;
        }
        return false;
    }

    private int findIndex(Object key) {
        int index = key.hashCode() % entries.length;
        if(index < 0) {
            index += entries.length;
        }
        return index;
    }

    @Override
    public boolean containsValue(Object value) { // O(m)
        for(Entry<K, V> e : entries) {
            if(e != null) {
                if(Objects.equals(value, e.value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) { //O(1)
        int index = findIndex(key);
        while(entries[index] != null) {
            if(Objects.equals(key, entries[index].key)) {
                return entries[index].value;
            }
            index = ++index % entries.length;
        }
        return null;
    }

    @Override
    public @Nullable V put(K key, V value) { // O(1)
        if(loadFactor() > LOAD_THRESHOLD) {
            rehash();
        }
        int index = findIndex(key);
        V result = null;
        // find open spot
        while(entries[index] != null && !Objects.equals(entries[index].key, key)) {
            index = ++index % entries.length;
        }
        // found a null or the key
        if(entries[index] == null) {
            // make a new one
            entries[index] = new Entry<>(key, value);
            ++numKeys;
        } else {
            result = entries[index].setValue(value);
        }
        return result;
    }

    @Override
    public V remove(Object key) {
        int index = findIndex(key);
        // look for it
        while(entries[index] != null && !Objects.equals(entries[index].key, key)) {
            index = ++index % entries.length;
        }
        if(entries[index] != null) {
            V old = entries[index].value;
            entries[index] = DELETED;
            ++numDeleted;
            --numKeys;
            return old;
        }
        return null;
    }

    @Override
    public void putAll(@NonNull Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public @NonNull Set<K> keySet() {
        return Set.of();
    }

    @Override
    public @NonNull Collection<V> values() {
        return List.of();
    }

    @Override
    public @NonNull Set<Map.Entry<K, V>> entrySet() {
        return Set.of();
    }

    private double loadFactor() {
        return (numKeys + numDeleted) / (double) entries.length;
    }

    private void rehash() {
        Entry<K, V>[] entriesCopy = this.entries;

        this.entries = new Entry[entries.length * 2];
        numKeys = 0;
        numDeleted = 0;

        for(Entry<K, V> e : entriesCopy) {
            if(e != null && e != DELETED) {
                put(e.key, e.value);
            }
        }
    }
}
