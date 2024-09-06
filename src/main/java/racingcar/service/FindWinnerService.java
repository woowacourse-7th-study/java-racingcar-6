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
            int currentPosition = FindCarService.getCurrentPosition(cars, i);
            if (max < FindCarService.getCurrentPosition(cars, i)) {
                max = currentPosition;
            }
        }
        return max;
    }

    public static List<String> findWinners(Cars cars, int max) {
        List<String> winners = new ArrayList<>();
        for (int i = ZERO.getNumber(); i < cars.length(); i++) {
            if (max == FindCarService.getCurrentPosition(cars, i)) {
                Car maxCar = FindCarService.getCar(cars, i);
                String maxCarName = maxCar.getName();
                winners.add(maxCarName);
            }
        }
        return winners;
    }


}
