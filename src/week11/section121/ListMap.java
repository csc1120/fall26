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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListMap<K, V> implements Map<K, V> {
    private class Entry<K, V> implements Map.Entry<K, V> {
        private K key;
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
        public String toString() {
            return "<" + key + ", " + value + ">";
        }
    }

    private List<Entry<K, V>> data;

    public ListMap() {
        data = new ArrayList<>();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        for(Entry<K, V> e : data) {
            if(e.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for(Entry<K, V> e : data) {
            if(e.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        for(Entry<K, V> e : data) {
            if(e.key.equals(key)) {
                // found it
                return e.value;
            }
        }
        return null;
    }

    @Override
    public @Nullable V put(K key, V value) {
        V result = null;
        for(Entry<K, V> e : data) {
            if(e.key.equals(key)) {
                // dup
                result = e.setValue(value);
            }
        }
        // new key, new entry
        data.add(new Entry<>(key, value));
        return result;
    }

    @Override
    public V remove(Object key) {
        for(Entry<K, V> e : data) {
            if(e.key.equals(key)) {
                // remove it
                V result = e.value;
                data.remove(e);
                return result;
            }
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
}
