package me.hdgenius.dynamiccollections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DynamicCollectionTest {

    @Test
    @DisplayName("The without method should return a collection that does not contain any of the excluded values")
    public void testThatTheWithoutMethodReturnsACollectionThatDoesNotContainAnyOfTheSpecifiedValues() {
        final Collection<Integer> excludedValues = Arrays.asList(1, 3, 5, 6);
        final Collection<Integer> collectionWithoutValues = DynamicCollection.without(excludedValues);

        for (final Integer valueToBeExcluded: excludedValues) {
            assertThat(collectionWithoutValues.contains(valueToBeExcluded), is(false));
        }
    }

    @Test
    @DisplayName("The without method should return a collection that contains every value that is not excluded")
    public void testThatTheWithoutMethodReturnsACollectionThatContainsEveryValueThatIsNotExcluded() {
        final Collection<Integer> excludedValues = Arrays.asList(1, 3, 5, 6);
        final Collection<Integer> collectionWithoutValues = DynamicCollection.without(excludedValues);

        for (final Integer valueToBeExcluded: excludedValues) {
            assertThat(collectionWithoutValues.contains(valueToBeExcluded), is(false));
        }
    }

}
