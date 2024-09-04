package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constant.Range.*;
import static racingcar.constant.Symbol.DASH;

public class Car {
    private final String name;
    private int position;

    public Car(final String name) {
        this.name = name;
        this.position = ZERO.getNumber();
    }

    public final String getName() {
        return name;
    }

    public final int getPosition() {
        return position;
    }

    public void race() {
        int number = Randoms.pickNumberInRange(RANDOM_RANGE_MIN.getNumber(), RANDOM_RANGE_MAX.getNumber());
        if (number >= FORWARD_MIN.getNumber()) {
            forward();
            System.out.print(DASH);
        }
    }

    private void forward() {
        position++;
    }

}