package racingcar.controller;

import racingcar.constant.ViewMessage;
import racingcar.domain.*;
import racingcar.dto.RacingWinners;
import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGameOutputView;

import java.util.LinkedList;
import java.util.List;

public class RacingGame {
    private final List<RacingCar> cars = new LinkedList<>();
    private RacingCarNames names = new RacingCarNames();
    private int count = 0;

    public RacingGame() {
    }

    public void playRacing() {
        while (isCarNamesOk()) {
            names = readCarNames();
        }

        while (isMovingCountOk()) {
            count = readMovingCount();
        }

        for (RacingCarName name : names.getNames()) {
            RacingCar car = new RacingCar(name);
            cars.add(car);
        }

        printRacingGameHeader();

        while (count > 0) {
            startRacingCars(cars);
            printRacingGamers(cars);
            count--;
        }

        printRacingGameWinners(cars);
    }

    public boolean isCarNamesOk() {
        return names.size() == 0;
    }

    public RacingCarNames readCarNames() {
        RacingGameOutputView view = new RacingGameOutputView();
        try {
            view.printConsoleMessage(ViewMessage.ENTER_THE_NAME_OF_THE_CAR_YOU_WANT_TO_RACE);
            RacingGameInputView console = new RacingGameInputView();
            return console.readCarNames();
        } catch (NullPointerException | IllegalArgumentException ignored) {
            view.printConsoleMessage(ViewMessage.ERROR_HEADER + ignored.getMessage());
        }
        return new RacingCarNames();
    }

    public boolean isMovingCountOk() {
        return this.count <= 0;
    }

    public int readMovingCount() {
        RacingGameOutputView view = new RacingGameOutputView();
        try {
            view.printConsoleMessage(ViewMessage.HOW_MANY_TIMES_IS_THE_GAME_PLAYED);
            RacingGameInputView console = new RacingGameInputView();
            return console.readMovingCount();
        } catch (NullPointerException | IllegalArgumentException ignored) {
            view.printConsoleMessage(ViewMessage.ERROR_HEADER + ignored.getMessage());
        }
        return 0;
    }

    public void startRacingCars(List<RacingCar> cars) {
        RandomIntegerGenerator generator = new RandomIntegerGenerator(0, 9);
        for (RacingCar car : cars) {
            car.moveForward(generator.pickRandomIntegerInRange());
        }
    }

    public void printRacingGameHeader() {
        RacingGameOutputView view = new RacingGameOutputView();
        view.printConsoleMessage(ViewMessage.GAME_RESULT);
    }

    public void printRacingGamers(List<RacingCar> cars) {
        RacingGameOutputView view = new RacingGameOutputView();
        for (RacingCar car : cars) {
            view.printConsoleMessage(car.information());
        }
        System.out.println();
    }

    public void printRacingGameWinners(List<RacingCar> cars) {
        RacingWinners winners = new RacingCars(cars).getWinners();
        RacingGameOutputView view = new RacingGameOutputView();
        view.printConsoleMessage(ViewMessage.GAME_WINNERS + joinNames(winners.getWinners()));
    }

    public String joinNames(List<RacingCar> winners) {
        List<String> names = new LinkedList<>();
        for (RacingCar car : winners) {
            names.add(car.name());
        }
        return String.join(", ", names);
    }
}
