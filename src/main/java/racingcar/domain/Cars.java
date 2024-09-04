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

    public Car get(String name) {
        for (Car car : cars) {
            if (name.equals(car.getName())) {
                return car;
            }
        }
        return null;
    }

    public Car get(int index) {
        return cars.get(index);
    }
    public int length() {
        return cars.size();
    }
}
