package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Cars {

    public static final int RANDOM_NUM_MIN = 0;
    public static final int RANDOM_NUM_MAX = 9;
    private final List<Car> racingCars;

    public Cars(final List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public void updateRaceRound() {
        racingCars.forEach(car -> car.moveForward(Randoms.pickNumberInRange(RANDOM_NUM_MIN, RANDOM_NUM_MAX)));
    }

    public List<Car> getCars() {
        return racingCars;
    }

    public int getMaxDistance() {
        return racingCars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    public List<Car> getWinners(final int maxDistance) {
        return racingCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }


}
