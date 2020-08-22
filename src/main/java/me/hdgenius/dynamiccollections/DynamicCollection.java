package me.hdgenius.dynamiccollections;

import me.hdgenius.dynamiccollections.builder.DynamicCollectionBuilder;

import java.util.*;

public final class DynamicCollection {

    public static <T> Set<T> without(final Collection<T> valuesToExclude) {
        return new ExclusionSet<T>(valuesToExclude);
    }

    public static <T> Set<T> without(final T ...valuesToExclude) {
        final Collection<T> collectionOfValuesToExclude = createSetFromArray(valuesToExclude);
        return without(collectionOfValuesToExclude);
    }

    public static <T> Set<T> ofAllValues() {
        return new ExclusionSet<>(new HashSet<>());
    }

    public static Collection<Long> forRange(final long start, final long end) {
        return new RangeCollection<>(start, end, x -> x + 1);
    }

    public static DynamicCollectionBuilder builder() {
        return new DynamicCollectionBuilder();
    }

    private static <T> Set<T> createSetFromArray(final T[] values) {
        final Set<T> result = new HashSet<>();
        Collections.addAll(result, values);
        return result;
    }

}
