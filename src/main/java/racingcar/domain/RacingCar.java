package racingcar.domain;

import racingcar.constant.Characters;
import racingcar.constant.ViewMessage;

public class RacingCar {
    private String name;
    private int distance;

    public RacingCar(RacingCarName carName) {
        if (isNull(carName)) {
            throw new NullPointerException(ViewMessage.NO_CAR_NAME_ENTERED);
        }
        name = carName.getName();
        distance = 0;
    }

    private boolean isNull(RacingCarName carName) {
        return name == null;
    }

    public void moveForward(int condition) {
        if (condition > 3) {
            distance += 1;
        }
    }

    public String information() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name)
          .append(Characters.SPACE)
          .append(Characters.COLON)
          .append(Characters.SPACE);
        for (int idx = 0; idx < distance; idx++) {
            sb.append(Characters.DASH);
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
