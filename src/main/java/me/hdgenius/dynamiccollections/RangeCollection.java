package me.hdgenius.dynamiccollections;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.UnaryOperator;

// This class only works with discrete datasets where the incrementer generates every value within the upper and lower bounds
public class RangeCollection<T> implements Collection<T> {

    final T startingValue;
    final T endingValue;
    final Comparator<T> comparator;
    final UnaryOperator<T> incrementer;

    RangeCollection(final T startingValue, final T endingValue, final Comparator<T> comparator, final UnaryOperator<T> incrementer) {
        this.startingValue = startingValue;
        this.endingValue = endingValue;
        this.comparator = comparator;
        this.incrementer = incrementer;
    }

    @Override
    public int size() {
        // iterate over the dataset and cache the number of items the first time this is called
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(final Object value) {
        return isWithinUpperBound((T) value) && isWithinLowerBound((T) value);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    private boolean isWithinLowerBound(final T value) {
        return comparator.compare(startingValue, value) <= 0;
    }

    private boolean isWithinUpperBound(final T value) {
        return comparator.compare(endingValue, value) >= 0;
    }
}
