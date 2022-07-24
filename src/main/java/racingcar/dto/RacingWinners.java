package racingcar.dto;

import racingcar.domain.RacingCar;

import java.util.List;

public class RacingWinners {
    private final List<RacingCar> winners;

    public RacingWinners(List<RacingCar> winners) {
        this.winners = winners;
    }

    public List<RacingCar> getWinners() {
        return winners;
    }
}
