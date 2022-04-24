package racingcar.domain;

import racingcar.constant.ViewMessage;

public class RacingCar {
    private static final String EM_DASH = "-";
    private static final String SPACE = " ";
    private static final String COLON = ":";

    private String name;
    private int distance;

    public RacingCar(String name) {
        if (isNull(name)) {
            throw new NullPointerException(ViewMessage.NO_CAR_NAME_ENTERED);
        }
        this.name = name;
        this.distance = 0;
    }

    public boolean isNull(String name) {
        return name == null;
    }

    public void moveForward(int condition) {
        if (condition > 3) {
            this.distance += 1;
        }
    }

    public String information() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(SPACE).append(COLON).append(SPACE);
        for (int idx = 0; idx < distance; idx++) {
            sb.append(EM_DASH);
        }
        return sb.toString();
    }

    public String name() {
        return this.name;
    }

    public int distance() {
        return this.distance;
    }
}
