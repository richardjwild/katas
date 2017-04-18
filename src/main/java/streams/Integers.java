package streams;

import java.util.stream.Stream;

public class Integers {

    public static Stream<Integer> from(int from) {
        return new Integers(from).getStream();
    }

    private int value;

    private Integers(int from) {
        value = from;
    }

    private Stream<Integer> getStream() {
        return Stream.generate(() -> value++);
    }
}
