package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;

    public Car(final String name) {
        this.name = name;
        this.position = 0;
    }

    public final String getName() {
        return name;
    }

    public final int getPosition() {
        return position;
    }

    public void race() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            forward();
            System.out.print("-");
        }
    }

    private void forward() {
        position++;
    }

}