package racingcar.dto;

import java.util.List;

public class RandomIntegers {
    private List<Integer> integers;

    public RandomIntegers(List<Integer> integers) {
        if (integers == null) {
            throw new NullPointerException("한 개 이상의 숫자가 생성되지 않았습니다.");
        }
        this.integers = integers;
    }

    public int get(int idx) {
        if (idx >= size()) {
            throw new IndexOutOfBoundsException("사용할 수 없는 인덱스 입니다.");
        }
        return this.integers.get(idx);
    }

    public int size() {
        return this.integers.size();
    }
}
