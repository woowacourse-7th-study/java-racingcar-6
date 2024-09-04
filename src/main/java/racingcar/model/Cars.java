package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Cars {
    private final List<Car> racingCars;

    public Cars(final List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public List<Car> updateRaceRound() {
        racingCars.forEach(car -> car.moveForward(Randoms.pickNumberInRange(0, 9)));
        return racingCars;
    }
}
