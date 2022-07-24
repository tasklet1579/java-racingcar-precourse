package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class RacingCarNameTest {
    @DisplayName("비정상적인 자동차 이름을 입력 받는다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {" ", "wo rld", "자동차이름", "!@#"})
    void constructor_throwException_givenWrongName(String name) {
        // when
        Throwable thrown = catchThrowable(() -> new RacingCarName(name));

        // then
        assertThat(thrown).isInstanceOfAny(NullPointerException.class, IllegalArgumentException.class);
    }
}
