package me.hdgenius.dynamiccollections;

import java.util.Collection;
import java.util.Iterator;

public class ExcludedCollection<T> implements Collection<T> {

    private Collection<T> valuesToExclude;

    ExcludedCollection(final Collection<T> valuesToExclude) {
        this.valuesToExclude = valuesToExclude;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(final Object value) {
        return !valuesToExclude.contains(value);
    }

    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("ExcludedCollection cannot be iterated over");
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException("ExcludedCollection cannot be converted to an array");
    }

    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("ExcludedCollection cannot be converted to an array");
    }

    public boolean add(final T t) {
        return valuesToExclude.remove(t);
    }

    public boolean remove(final Object o) {
        return valuesToExclude.add((T) o);
    }

    public boolean containsAll(final Collection<?> values) {
        return values.stream().noneMatch(valuesToExclude::contains);
    }

    public boolean addAll(final Collection<? extends T> c) {
        c.forEach(valuesToExclude::remove);
        return true;
    }

    public boolean removeAll(final Collection<?> values) {
        return valuesToExclude.addAll((Collection<T>) values);
    }

    public boolean retainAll(final Collection<?> valuesToRetain) {
        valuesToExclude = new ExcludedCollection<>((Collection<T>) valuesToRetain);
        return true;
    }

    public void clear() {

    }
}
