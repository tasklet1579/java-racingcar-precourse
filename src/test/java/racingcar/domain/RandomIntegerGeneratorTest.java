package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class RandomIntegerGeneratorTest {
    @DisplayName("종료값이 시작값 보다 작을 수 없다.")
    @Test
    void constructor_throwException_givenEndLessThanStart() {
        // given
        int inclusiveStart = 9;
        int inclusiveEnd = 1;

        // when
        Throwable thrown = catchThrowable(() -> new RandomIntegerGenerator(inclusiveStart, inclusiveEnd));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                          .hasMessage("종료값이 시작값 보다 작을수 없습니다.");
    }

    @DisplayName("시작값 보다 크거나 같고 종료값 보다 작거나 같은 숫자를 한 개 생성한다.")
    @ParameterizedTest
    @MethodSource("integerInRange")
    void pickRandomIntegerInRange(int inclusiveStart, int inclusiveEnd) {
        // given
        RandomIntegerGenerator generator = new RandomIntegerGenerator(inclusiveStart, inclusiveEnd);

        // when
        int integer = generator.pickRandomIntegerInRange();

        // then
        assertThat(integer).isBetween(inclusiveStart, inclusiveEnd);
    }

    static Stream<Arguments> integerInRange() {
        return Stream.of(
                Arguments.of(0, 9),
                Arguments.of(0, 0),
                Arguments.of(-100, 100)
        );
    }

    @DisplayName("시작값 보다 크거나 같고 종료값 보다 작거나 같은 숫자를 한 개 이상 생성한다.")
    @ParameterizedTest
    @MethodSource("integersInRange")
    void pickRandomIntegersInRange(int inclusiveStart, int inclusiveEnd, int count) {
        // given
        RandomIntegerGenerator generator = new RandomIntegerGenerator(inclusiveStart, inclusiveEnd);

        // when
        RandomIntegers integers = generator.pickRandomIntegersInRange(count);

        // then
        assertThat(count).isEqualTo(integers.size());
    }

    static Stream<Arguments> integersInRange() {
        return Stream.of(
                Arguments.of(0, 0, 1),
                Arguments.of(0, 9, 5),
                Arguments.of(-100, 100, 100)
        );
    }
}
