package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.RandomIntegers;

import java.util.LinkedList;
import java.util.List;

public class RandomIntegerGenerator {
    private final int inclusiveStart;
    private final int inclusiveEnd;

    public RandomIntegerGenerator(int inclusiveStart, int inclusiveEnd) {
        if (inclusiveStart > inclusiveEnd) {
            throw new IllegalArgumentException("종료값이 시작값 보다 작을수 없습니다.");
        }
        this.inclusiveStart = inclusiveStart;
        this.inclusiveEnd = inclusiveEnd;
    }

    public int pickRandomIntegerInRange() {
        return Randoms.pickNumberInRange(getInclusiveStart(), getInclusiveEnd());
    }

    public RandomIntegers pickRandomIntegersInRange(int count) {
        if (count == 0) {
            throw new IllegalArgumentException("한 개 이상의 숫자를 생성해야 합니다.");
        }
        List<Integer> integers = new LinkedList<>();
        for (int idx = 0; idx < count; idx++) {
            int integer = pickRandomIntegerInRange();
            integers.add(integer);
        }
        return new RandomIntegers(integers);
    }

    public int getInclusiveStart() {
        return this.inclusiveStart;
    }

    public int getInclusiveEnd() {
        return this.inclusiveEnd;
    }
}
