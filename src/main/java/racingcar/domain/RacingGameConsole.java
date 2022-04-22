package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class RacingGameConsole {
    private static final String COMMA = ",";
    private static final String RACING_CAR_NAME = "^[a-z]{0,5}$";

    public RacingCarPart readCarNames() {
        String carNames = Console.readLine().trim();
        if (isNull(carNames) || isEmpty(carNames)) {
            throw new NullPointerException("자동차 이름이 입력되지 않았습니다.");
        }
        RacingCarPart part = new RacingCarPart();
        for (String name : extractCarNames(carNames)) {
            isCarNameFiveCharactersOrLess(name);
            isCarNameInLowercaseEnglish(name);
            part.addName(name);
        }
        return part;
    }

    public int readMovingCount() {
        String input = Console.readLine().trim();
        if (isNull(input) || isEmpty(input)) {
            throw new NullPointerException("이동 횟수가 입력되지 않았습니다.");
        }
        int carCount = parseInt(input);
        if (isNegativeInteger(carCount)) {
            throw new IllegalArgumentException("1 보다 작은 값을 입력할 수 없습니다.");
        }
        return carCount;
    }

    public boolean isNull(String name) {
        return name == null;
    }

    public boolean isEmpty(String name) {
        return name.isEmpty();
    }

    public String[] extractCarNames(String input) {
        return input.split(COMMA);
    }

    public void isCarNameFiveCharactersOrLess(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void isCarNameInLowercaseEnglish(String name) {
        if (!Pattern.compile(RACING_CAR_NAME).matcher(name).matches()) {
            throw new IllegalArgumentException("자동차 이름은 영어 소문자만 가능합니다.");
        }
    }

    public int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("시도 횟수는 숫자여야 합니다.");
        }
    }

    public boolean isNegativeInteger(int input) {
        return input <= 0;
    }
}
