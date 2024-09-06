package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.Range.INT_MIN;
import static racingcar.constant.Range.ZERO;

public class FindWinnerService {
    private FindWinnerService() {
    }

    public static int findMax(Cars cars) {
        int max = INT_MIN.getNumber();
        for (int i = ZERO.getNumber(); i < cars.length(); i++) {
            int currentPosition = getCurrentPosition(cars, i);
            if (max < getCurrentPosition(cars, i)) {
                max = currentPosition;
            }
        }
        return max;
    }

    public static List<String> findWinners(Cars cars, int max) {
        List<String> winners = new ArrayList<>();
        for (int i = ZERO.getNumber(); i < cars.length(); i++) {
            if (max == getCurrentPosition(cars, i)) {
                winners.add(getCar(cars, i).getName());
            }
        }
        return winners;
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
