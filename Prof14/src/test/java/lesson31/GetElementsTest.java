package lesson31;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class GetElementsTest {
    @Test
    public void testGetElements()
    {
        List<String> countries = Arrays.asList("Cuba", "Ecuador", "Brazil", "Canada");
        Collection<String> result = HomeWork.getElements(countries, 1, 2);
        assertEquals(result.size(), 2);
        assertThat(result, hasItems("Ecuador", "Brazil"));
    }
}