package racingcar.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class RacingCarNames {
    private final List<RacingCarName> names = new LinkedList<>();

    public RacingCarNames() { }

    public void addName(String name) {
        names.add(new RacingCarName((name)));
    }

    public List<RacingCarName> getNames() {
        return names;
    }

    public int size() {
        return names.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarNames that = (RacingCarNames) o;
        return Objects.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }

    @Override
    public String toString() {
        return "RacingCarNames{" +
                "names=" + names +
                '}';
    }
}
