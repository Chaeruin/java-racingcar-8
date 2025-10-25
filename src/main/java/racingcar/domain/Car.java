package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public Car moveForward() {
        if (isFourOrMore()) {
            position++;
        }
        return this;
    }

    public boolean isFourOrMore() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
