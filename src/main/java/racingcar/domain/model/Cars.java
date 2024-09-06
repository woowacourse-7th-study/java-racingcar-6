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

    public int getMaxDistance() { // 최대 거리를 반환하는 메서드
        return carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    public List<Car> getWinners(final int maxDistance) { // 최대거리를 가진(우승자) carList를 반환하는 메서드
        return carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }


}
