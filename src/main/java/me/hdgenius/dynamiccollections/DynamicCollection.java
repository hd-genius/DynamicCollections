package me.hdgenius.dynamiccollections;

import java.util.*;
import java.util.stream.Collectors;

public class DynamicCollection<T> implements Set<T> {

    private final Set<T> values;

    private DynamicCollection(final Collection<T> values) {
        this.values = new HashSet<>(values);
    }

    DynamicCollection<T> without(Collection<T> valuesToExclude) {
        final Collection<T> newCollectionValues = values.stream()
                .filter(x -> !valuesToExclude.contains(x))
                .collect(Collectors.toSet());
        return DynamicCollection.of(newCollectionValues);
    }

    static <T> DynamicCollection<T> of(final Collection<T> collection) {
        return new DynamicCollection<>(collection);
    }

    @Override
    public int size() {
        return values.size();
    }

    @Override
    public boolean isEmpty() {
        return values.isEmpty();
    }

    @Override
    public boolean contains(final Object o) {
        return values.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return values.iterator();
    }

    @Override
    public Object[] toArray() {
        return values.toArray();
    }

    @Override
    public <T1> T1[] toArray(final T1[] a) {
        return values.toArray(a);
    }

    @Override
    public boolean add(final T t) {
        return values.add(t);
    }

    @Override
    public boolean remove(final Object o) {
        return values.remove(o);
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        return values.containsAll(c);
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        return values.addAll(c);
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        return values.retainAll(c);
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        return values.removeAll(c);
    }

    @Override
    public void clear() {
        values.clear();
    }
}
