package racingcar.domain;

import racingcar.dto.RacingWinners;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public RacingWinners getWinners() {
        int maxDistance = maxDistance();
        List<RacingCar> winners = cars.stream()
                                      .filter(car -> car.distance() == maxDistance)
                                      .collect(Collectors.toList());

        return new RacingWinners(winners);
    }

    private int maxDistance() {
        RacingCar winner = cars.stream()
                               .max(Comparator.comparingInt(RacingCar::distance))
                               .orElseThrow(NoSuchElementException::new);
        return winner.distance();
    }
}
