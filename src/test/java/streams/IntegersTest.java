package streams;

import org.junit.Test;

import java.util.Collection;
import java.util.stream.Collectors;

import static org.fest.assertions.Assertions.assertThat;

public class IntegersTest {

    @Test
    public void testStreamOfIntegers() {
        Collection<Integer> result = Integers.from(50).limit(10).collect(Collectors.toList());

        assertThat(result).containsOnly(50, 51, 52, 53, 54, 55, 56, 57, 58, 59);
    }
}
