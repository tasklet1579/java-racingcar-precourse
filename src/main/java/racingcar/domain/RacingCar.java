package racingcar.domain;

import java.util.regex.Pattern;

public class RacingCar {
    private static final String RACING_CAR_NAME = "^[a-z]{0,5}$";
    private String name;
    private int distance;

    public RacingCar(String name) {
        if (validateNullCheck(name)) {
            throw new NullPointerException("자동차 이름이 입력되지 않았습니다.");
        }
        if (validateLengthCheck(name) || validateNameCheck(name)) {
            throw new IllegalArgumentException("자동차 이름은 영어 소문자 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.distance = 0;
    }

    public boolean validateNullCheck(String name) {
        return name == null;
    }

    public boolean validateLengthCheck(String name) {
        return name.length() < 1 || name.length() > 5;
    }

    public boolean validateNameCheck(String name) {
        return !Pattern.compile(RACING_CAR_NAME).matcher(name).matches();
    }

    public void moveForward(int condition) {
        if (condition > 3) {
            this.distance += 1;
        }
    }

    public String name() {
        return "RacingCar{" +
                "name='" + name + '\'' +
                '}';
    }

    public int distance() {
        return this.distance;
    }
}
