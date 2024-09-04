package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void createCars(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }
}
