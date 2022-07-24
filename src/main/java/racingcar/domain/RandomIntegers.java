package racingcar.domain;

import racingcar.constant.ViewMessage;

import java.util.List;

public class RandomIntegers {
    private final List<Integer> integers;

    public RandomIntegers(final List<Integer> integers) {
        if (integers == null) {
            throw new NullPointerException(ViewMessage.AT_LEAST_ONE_NUMBER_MUST_BE_GENERATED);
        }
        this.integers = integers;
    }

    public List<Integer> getIntegers() {
        return integers;
    }

    public int size() {
        return integers.size();
    }

    public boolean isBetween(int inclusiveStart, int inclusiveEnd) {
        boolean isGreaterThanStart = integers.stream()
                                             .anyMatch(integer -> integer >= inclusiveStart);
        boolean isLessThanEnd = integers.stream()
                                        .anyMatch(integer -> integer <= inclusiveEnd);

        return isGreaterThanStart && isLessThanEnd;
    }
}
