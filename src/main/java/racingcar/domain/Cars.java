package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void createCars(String carNames) {
        String[] names = carNames.split(",");
        for (String name : names) {
            cars.add(new Car(name));
        }
    }
}
