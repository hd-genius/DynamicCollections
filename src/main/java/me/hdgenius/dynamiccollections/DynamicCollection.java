package me.hdgenius.dynamiccollections;

import java.util.Collection;

public final class DynamicCollection {

    public static <T> Collection<T> without(final Collection<T> valuesToExclude) {
        return new ExcludedCollection<T>(valuesToExclude);
    }

    public static Collection<Long> forRange(final long start, final long end) {
        return new RangeCollection<>(start, end, x -> x + 1);
    }

}
