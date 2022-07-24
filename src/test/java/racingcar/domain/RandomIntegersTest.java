package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RandomIntegersTest {
    @DisplayName("시작값 보다 크거나 같고 종료값 보다 작거나 같은지 확인한다.")
    @Test
    void isBetween() {
        // given
        int inclusiveStart = 1;
        int inclusiveEnd = 9;

        // when
        RandomIntegers integers = new RandomIntegers(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        // then
        assertThat(integers.isBetween(inclusiveStart, inclusiveEnd)).isTrue();
    }
}