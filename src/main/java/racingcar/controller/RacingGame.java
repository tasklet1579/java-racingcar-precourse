package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarPart;
import racingcar.domain.RacingGameConsole;
import racingcar.domain.RandomIntegerGenerator;
import racingcar.dto.RacingGameResult;
import racingcar.view.RacingGameOutputView;

import java.util.LinkedList;
import java.util.List;

public class RacingGame {
    private List<RacingCar> cars = new LinkedList<>();
    private RacingCarPart part = new RacingCarPart();
    private int count = 0;

    public RacingGame() { }

    public void playRacing() {
        while (isCarNamesOk()) {
            this.part = readCarNames();
        }

        while (isMovingCountOk()) {
            this.count = readMovingCount();
        }

        for (String name : this.part.getNames()) {
            RacingCar car = new RacingCar(name);
            cars.add(car);
        }

        printRacingGameHeader();

        while (this.count > 0) {
            startRacingCars(this.cars);
            printRacingGamers(this.cars);
            this.count--;
        }

        printRacingGameWinners(this.cars);
    }

    public boolean isCarNamesOk() {
        return this.part.size() == 0;
    }

    public RacingCarPart readCarNames() {
        RacingGameOutputView view = new RacingGameOutputView();
        try {
            view.printConsoleMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            RacingGameConsole console = new RacingGameConsole();
            return console.readCarNames();
        } catch (NullPointerException | IllegalArgumentException ignored) {
            view.printConsoleMessage("[ERROR] " + ignored.getMessage());
        }
        return new RacingCarPart();
    }

    public boolean isMovingCountOk() {
        return this.count <= 0;
    }

    public int readMovingCount() {
        RacingGameOutputView view = new RacingGameOutputView();
        try {
            view.printConsoleMessage("시도할 회수는 몇회인가요?");
            RacingGameConsole console = new RacingGameConsole();
            return console.readMovingCount();
        } catch (NullPointerException | IllegalArgumentException ignored) {
            view.printConsoleMessage("[ERROR] " + ignored.getMessage());
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
        view.printConsoleMessage("실행 결과");
    }

    public void printRacingGamers(List<RacingCar> cars) {
        RacingGameOutputView view = new RacingGameOutputView();
        for (RacingCar car : cars) {
            view.printConsoleMessage(car.information());
        }
        System.out.println();
    }

    public void printRacingGameWinners(List<RacingCar> cars) {
        List<RacingCar> winners = new LinkedList<>();
        RacingGameResult result = new RacingGameResult(winners, 0);
        for (RacingCar car : cars) {
            result = measureCarDistanceFromStartLine(car, result);
        }

        RacingGameOutputView view = new RacingGameOutputView();
        view.printConsoleMessage("최종 우승자는 " + joinNames(result.winners()) + " 입니다.");
    }

    public RacingGameResult measureCarDistanceFromStartLine(RacingCar car, RacingGameResult result) {
        if (car.distance() == result.maxDistance()) {
            result.add(car);
        }
        if (car.distance() > result.maxDistance()) {
            result.changeMaxDistance(car.distance());
            result.clear();
            result.add(car);
        }
        return result;
    }

    public String joinNames(List<RacingCar> winners) {
        List<String> names = new LinkedList<>();
        for (RacingCar car : winners) {
            names.add(car.name());
        }
        return String.join(", ", names);
    }
}
