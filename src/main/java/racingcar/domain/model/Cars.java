package racingcar.domain.model;

import racingcar.domain.Movable;

import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(final List<Car> carList) {
        this.carList = carList;
    }

    public void updateRaceRound(Movable movable) {
        carList.forEach(car -> car.moveForward(movable));
    }

    public List<Car> getCars() {
        return carList;
    }

    public int getMaxDistance() {
        return carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    public List<Car> getWinners(final int maxDistance) {
        return carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }


}
