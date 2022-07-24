package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingWinners;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {
    @DisplayName("자동차 경주 게임 우승자")
    @Test
    void getWinners() {
        // given
        RacingCar car1 = new RacingCar("현대", 1);
        RacingCar car2 = new RacingCar("기아", 4);
        RacingCar car3 = new RacingCar("르노", 5);
        RacingCar car4 = new RacingCar("포드", 5);

        // when
        RacingWinners winners = new RacingCars(Arrays.asList(car1, car2, car3, car4)).getWinners();

        // then
        assertThat(winners.getWinners()).isEqualTo(Arrays.asList(car3, car4));
    }
}
