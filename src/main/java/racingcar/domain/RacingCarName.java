package racingcar.domain;

import racingcar.constant.Regex;
import racingcar.constant.ViewMessage;

import java.util.regex.Pattern;

public class RacingCarName {
    private final String name;

    public RacingCarName(final String name) {
        isNullOrEmpty(name);
        isCarNameFiveCharactersOrLess(name.trim());
        isCarNameInLowercaseEnglish(name.trim());
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    private void isNullOrEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new NullPointerException(ViewMessage.NO_CAR_NAME_ENTERED);
        }
    }

    private void isCarNameFiveCharactersOrLess(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException(ViewMessage.CAR_NAMES_MUST_BE_FIVE_CHARACTERS_OR_LESS);
        }
    }

    private void isCarNameInLowercaseEnglish(String name) {
        if (!Pattern.compile(Regex.RACING_CAR_NAME).matcher(name).matches()) {
            throw new IllegalArgumentException(ViewMessage.CAR_NAMES_CAN_ONLY_BE_IN_LOWERCASE_ENGLISH);
        }
    }
}
