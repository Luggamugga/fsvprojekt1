package project01;

import java.util.List;

import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.NotEmpty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistogramTests {
    // Note: this method can be used to run the unit test without a test framework (e.g. to debug)
    public static void main(String[] args) {
        HistogramTests h = new HistogramTests();
        h.example();
    }

    @Test
    void example() {
        Histogram histogram = new Histogram(2, 3, 0, 5, 5, 6, -2, 9, 0, 3, 5);
        assertEquals(-2, histogram.min());
        assertEquals(9, histogram.max());

        assertEquals(0, histogram.count(-3));
        assertEquals(1, histogram.count(-2));
        assertEquals(0, histogram.count(-1));
        assertEquals(2, histogram.count(0));
        assertEquals(0, histogram.count(1));
        assertEquals(1, histogram.count(2));
        assertEquals(2, histogram.count(3));
        assertEquals(0, histogram.count(4));
        assertEquals(3, histogram.count(5));
        assertEquals(1, histogram.count(6));
        assertEquals(0, histogram.count(7));
        assertEquals(0, histogram.count(8));
        assertEquals(1, histogram.count(9));
        assertEquals(0, histogram.count(10));
    }

    int countOccurrences(int value, List<Integer> data) {
        return (int) data.stream().filter(i -> i == value).count();
    }

    @Property
    void histogramDoesNotCrash(
            @ForAll @NotEmpty List<@IntRange(min = -1000000, max = 1000000) Integer> data
    ) {
        new Histogram(data);
    }

    @Property
    void histogramCount(
            @ForAll @NotEmpty List<@IntRange(min = -1000000, max = 1000000) Integer> data,
            @ForAll @IntRange(min = -1000000, max = 1000000) int value
    ) {
        Histogram histogram = new Histogram(data);
        int expected = countOccurrences(value, data);
        int actual = histogram.count(value);

        assertEquals(expected, actual);
    }

    @Property
    void histogramRange(
            @ForAll @NotEmpty List<@IntRange(min = -1000000, max = 1000000) Integer> data,
            @ForAll @IntRange(min = -1000000, max = 1000000) int value
    ) {
        Histogram histogram = new Histogram(data);
        Assume.that(countOccurrences(value, data) > 0);
        Assertions.assertTrue(value >= histogram.min() && value <= histogram.max());
    }

    @Property
    void histogramRange(
            @ForAll @NotEmpty List<@IntRange(min = -10000000, max = 10000000) Integer> data
    ) {
        Histogram histogram = new Histogram(data);
        for (int value : data) {
            Assertions.assertTrue(value >= histogram.min() && value <= histogram.max());
        }
    }
}
