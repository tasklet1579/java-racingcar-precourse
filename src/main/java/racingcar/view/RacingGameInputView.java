package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Characters;
import racingcar.constant.Regex;
import racingcar.constant.ViewMessage;
import racingcar.domain.RacingCarNames;

import java.util.regex.Pattern;

public class RacingGameInputView {
    public RacingCarNames readCarNames() {
        String carNames = Console.readLine();
        if (isNull(carNames) || isEmpty(carNames)) {
            throw new NullPointerException(ViewMessage.NO_CAR_NAME_ENTERED);
        }
        RacingCarNames names = new RacingCarNames();
        for (String name : extractCarNames(carNames)) {
            names.addName(name.trim());
        }
        return names;
    }

    public int readMovingCount() {
        String input = Console.readLine();
        if (isNull(input) || isEmpty(input)) {
            throw new NullPointerException(ViewMessage.NUMBER_OF_PROGRESS_IN_THE_GAME_HAS_NOT_BEEN_ENTERED);
        }
        int carCount = parseInt(input.trim());
        if (isNegativeInteger(carCount)) {
            throw new IllegalArgumentException(ViewMessage.YOU_CANNOT_ENTER_A_VALUE_LESS_THAN_ONE);
        }
        return carCount;
    }

    private boolean isNull(String name) {
        return name == null;
    }

    private boolean isEmpty(String name) {
        return name.isEmpty();
    }

    private String[] extractCarNames(String input) {
        return input.split(Characters.COMMA);
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ViewMessage.NUMBER_OF_ADVANCES_IN_THE_GAME_MUST_BE_A_NUMBER);
        }
    }

    private boolean isNegativeInteger(int input) {
        return input <= 0;
    }
}
