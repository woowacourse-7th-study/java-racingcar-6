package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Cars {
    private final List<Car> racingCars;

    public Cars(final List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public void updateRaceRound(Movable movable) {
        racingCars.forEach(car -> car.moveForward(movable));
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
