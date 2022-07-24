package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.RacingGameInputView;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingCarNamesTest {
    @DisplayName("자동차 이름을 입력 받는다.")
    @Test
    void acceptCarNames() {
        // given
        RacingCarNames expected = new RacingCarNames();
        expected.addName("pobi");
        expected.addName("woni");
        expected.addName("jun");

        // when
        System.setIn(new ByteArrayInputStream("pobi, woni, jun".getBytes(StandardCharsets.UTF_8)));
        RacingGameInputView console = new RacingGameInputView();
        RacingCarNames actual = console.readCarNames();

        // then
        assertEquals(expected.getNames(), actual.getNames());
    }
}
