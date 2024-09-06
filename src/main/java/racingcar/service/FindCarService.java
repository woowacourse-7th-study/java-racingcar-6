package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class FindCarService {
    private FindCarService() {
    }

    public static Car getCar(Cars cars, int i) {
        return cars.get(i);
    }

    public static Car getCar(Cars cars, String name) {
        return cars.get(name);
    }

    public static int getCurrentPosition(Cars cars, int i) {
        return getCar(cars, i).getPosition();
    }
}
