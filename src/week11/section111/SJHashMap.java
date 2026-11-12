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
    public boolean containsKey(Object key) {
        // get index
        int index = key.hashCode() % entries.length;
        if(index < 0) {
            index += entries.length;
        }
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

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public @Nullable V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
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
}
