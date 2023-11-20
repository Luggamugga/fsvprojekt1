package project01;

import java.util.ArrayList;
import java.util.List;

import net.jqwik.api.constraints.StringLength;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunLengthTests {

    // Note: this method can be used to run the unit test without a test framework (e.g. to debug)
    public static void main(String[] args) {
        RunLengthTests r = new RunLengthTests();
        r.example();
    }

    @Test
    void example() {
        List<String> input = List.of("A", "A", "B");
        List<Run<String>> expected = List.of(new Run<>(2, "A"), new Run<>(1, "B"));
        assertEquals(expected, RunLength.encode(input));
    }

    public static Integer sum(List<Integer> elems) {
        return elems.stream().reduce(0, Integer::sum);
    }

    @Property
    void canDecode(@ForAll List<@StringLength(min = 1, max = 20) String> input) {
        List list = new ArrayList(input);
        List encoded = RunLength.encode(list);
        List<Object> decoded = RunLength.decode(encoded);

        assertEquals(list, decoded);

    }

    @Property
    void optimizedSum(@ForAll List<Integer> input) {
        // TODO: check that the optimized sum method of RunLength computes on the encoding
        //       the same result as the reference implementation (method sum above) on the given input
    }
}
