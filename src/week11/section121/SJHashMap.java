/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week11.section121;

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
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }

        @Override
        public boolean equals(Object o) {
            // this
            if(this == o) {
                return true;
            }
//            if(o == null) {
//                return false;
//            }
//            if(!(o instanceof Entry<?, ?>)) {
//                return false;
//            }
            if(!(o instanceof Map.Entry<?, ?> that)) {
                return false;
            }

            return Objects.equals(key, that.getKey()) &&
                    Objects.equals(value, that.getValue());
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public String toString() {
            return "<" + key + ", " + value + ">";
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
        numDeleted = 0;
        numKeys = 0;
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
    public boolean containsKey(Object key) { // O(1)
        int index = findIndex(key);
        while(entries[index] != null) {
            if(Objects.equals(key, entries[index].key)) {
                return true;
            }
            index = ++index % entries.length;
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
            if(e != null && Objects.equals(value, e.value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int index = findIndex(key);
        while(entries[index] != null && !Objects.equals(entries[index].key, key)) {
            index = ++index % entries.length;
        }
        if(entries[index] != null) {
            return entries[index].value;
        }
        return null;
    }

    @Override
    public @Nullable V put(K key, V value) { // O(1)
        if(loadFactor() > LOAD_THRESHOLD) {
            rehash();
        }
        V result = null;
        int index = findIndex(key);
        while(entries[index] != null && !Objects.equals(entries[index].key, key)) {
            index = ++index % entries.length;
        }
        if(entries[index] == null) {
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
        while(entries[index] != null && !Objects.equals(entries[index].key, key)) {
            index = ++index % entries.length;
        }
        if(entries[index] != null) {
            // delete it
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
        Entry<K, V>[] old = this.entries;
        this.entries = new Entry[entries.length * 2];
        numDeleted = 0;
        numKeys = 0;
        for(Entry<K, V> e : old) {
            if(e != null && e != DELETED) {
                put(e.key, e.value);
            }
        }
    }
}
