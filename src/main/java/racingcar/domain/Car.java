package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int position;
    private final NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        this.name = name;
        this.position = 0;
        this.numberGenerator = numberGenerator;
    }

    public Car moveForward() {
        if (isFourOrMore()) {
            position++;
        }
        return this;
    }

    public boolean isFourOrMore() {
        return numberGenerator.pick() >= 4;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
