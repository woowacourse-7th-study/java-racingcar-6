package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void createCars(String carNames) {
        String[] carNameArray = carNames.split(",");
        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }
    }
}
