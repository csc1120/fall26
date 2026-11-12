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
    private class Entry<K, V> implements Map.Entry<K, V> {
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
    public boolean containsKey(Object key) {
        int index = key.hashCode() % entries.length;
        if(index < 0) {
            index += entries.length;
        }
        while(entries[index] != null) {
            if(Objects.equals(key, entries[index].key)) {
                return true;
            }
            index = ++index % entries.length;
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
