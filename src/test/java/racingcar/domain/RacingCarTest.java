package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    @DisplayName("자동차를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"hello", "world", "sung", "woo"})
    void createRacingCar(String name) {
        assertThatCode(() -> new RacingCar(new RacingCarName(name))).doesNotThrowAnyException();
    }

    @DisplayName("자동차를 전진한다.")
    @ParameterizedTest
    @MethodSource("nameAndCondition")
    void moveForward(String name, int condition) {
        // given
        RacingCar car = new RacingCar(new RacingCarName(name));

        // when
        car.moveForward(condition);

        // then
        assertThat(car.distance()).isEqualTo(1);
    }

    static Stream<Arguments> nameAndCondition() {
        return Stream.of(
                Arguments.of("ford", 4),
                Arguments.of("gm", 5),
                Arguments.of("tesla", 6),
                Arguments.of("ford", 7)
        );
    }

    @DisplayName("자동차를 멈춘다.")
    @ParameterizedTest
    @MethodSource("nameAndInvalidCondition")
    void stayInPlace(String name, int condition) {
        // given
        RacingCar car = new RacingCar(new RacingCarName(name));

        // when
        car.moveForward(condition);

        assertThat(car.distance()).isEqualTo(0);
    }

    static Stream<Arguments> nameAndInvalidCondition() {
        return Stream.of(
                Arguments.of("ford", 0),
                Arguments.of("gm", 1),
                Arguments.of("tesla", 2),
                Arguments.of("ford", 3)
        );
    }
}
