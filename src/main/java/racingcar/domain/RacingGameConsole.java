package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Characters;
import racingcar.constant.Regex;
import racingcar.constant.ViewMessage;

import java.util.regex.Pattern;

public class RacingGameConsole {
    public RacingCarPart readCarNames() {
        String carNames = Console.readLine().trim();
        if (isNull(carNames) || isEmpty(carNames)) {
            throw new NullPointerException(ViewMessage.NO_CAR_NAME_ENTERED);
        }
        RacingCarPart part = new RacingCarPart();
        for (String name : extractCarNames(carNames)) {
            isCarNameFiveCharactersOrLess(name.trim());
            isCarNameInLowercaseEnglish(name.trim());
            part.addName(name.trim());
        }
        return part;
    }

    public int readMovingCount() {
        String input = Console.readLine().trim();
        if (isNull(input) || isEmpty(input)) {
            throw new NullPointerException(ViewMessage.NUMBER_OF_PROGRESS_IN_THE_GAME_HAS_NOT_BEEN_ENTERED);
        }
        int carCount = parseInt(input);
        if (isNegativeInteger(carCount)) {
            throw new IllegalArgumentException(ViewMessage.YOU_CANNOT_ENTER_A_VALUE_LESS_THAN_ONE);
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
        return input.split(Characters.COMMA);
    }

    public void isCarNameFiveCharactersOrLess(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException(ViewMessage.CAR_NAMES_MUST_BE_FIVE_CHARACTERS_OR_LESS);
        }
    }

    public void isCarNameInLowercaseEnglish(String name) {
        if (!Pattern.compile(Regex.RACING_CAR_NAME).matcher(name).matches()) {
            throw new IllegalArgumentException(ViewMessage.CAR_NAMES_CAN_ONLY_BE_IN_LOWERCASE_ENGLISH);
        }
    }

    public int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ViewMessage.NUMBER_OF_ADVANCES_IN_THE_GAME_MUST_BE_A_NUMBER);
        }
    }

    public boolean isNegativeInteger(int input) {
        return input <= 0;
    }
}
