package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGame;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatCode;

public class RacingGameTest {
    private RacingGame game;

    @BeforeEach
    void init() {
        game = new RacingGame();
    }

    @DisplayName("자동차 경주 게임 테스트")
    @Test
    void racingGameTest() {
        assertThatCode(() -> {
            final byte[] buf = String.join("\n", "pobi,woni,jun", "5")
                                     .getBytes();
            System.setIn(new ByteArrayInputStream(buf));
            game.playRacing();
        }).doesNotThrowAnyException();
    }
}
