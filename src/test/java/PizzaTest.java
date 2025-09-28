import epam.PizzaSplit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTest {

    @ParameterizedTest
    @MethodSource("data")
    public void calculationTest(long a, long b, long result) {
        assertEquals(result, PizzaSplit.countPizza(a, b));
    }

    @ParameterizedTest
    @MethodSource("badData")
    public void calculationNegativeTest(long a, long b) {
        Exception e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> PizzaSplit.countPizza(a, b));
        assertEquals("Параметр не может быть отрицательным или равен 0", e.getMessage());
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(1, 8, 1),
                Arguments.of(8, 1, 8),
                Arguments.of(1000, 12, 250),
                Arguments.of(8, 1000, 1),
                Arguments.of(1000, 1000, 1),
                Arguments.of(12, 8, 3),
                Arguments.of(4, 8, 1),
                Arguments.of(13, 7, 13),
                Arguments.of(1, 1, 1),
                Arguments.of(Integer.MAX_VALUE, 6, Integer.MAX_VALUE)
        );
    }

    static Stream<Arguments> badData() {
        return Stream.of(
                Arguments.of(0, 8),
                Arguments.of(12, 0),
                Arguments.of(8, -1),
                Arguments.of(-1, 8)
        );
    }
}
