package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.RandomNumberService;
import racingcar.service.UserInputService;
import racingcar.service.UserInputValidator;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.Range.*;
import static racingcar.constant.Symbol.COMMA;

public class RaceController {
    String[] carNames;
    Integer rounds;
    Cars cars;
    List<String> winners;

    public void run() {
        setup();
        init();
        raceRounds();
        ranking();
    }

    private void setup() {
        String input = UserInputService.requestCarNames();
        UserInputValidator.validateCarNames(input);
        carNames = splitNames(input);

        input = UserInputService.requestRounds();
        UserInputValidator.validateRounds(input);
        rounds = Integer.parseInt(input);
    }

    private void init() {
        cars = new Cars();
        cars.createCars(carNames);
    }

    private void raceRounds() {
        OutputView.printProcess();
        for (int round = ZERO.getNumber(); round < rounds; round++) {
            raceEachCar();
            System.out.println();
        }
    }

    private void raceEachCar() {
        for (String carName : carNames) {
            race(carName);
            System.out.println();
        }
    }

    private void race(String carName) {
        OutputView.printCarName(carName);
        Car currentCar = getCar(carName);
        printExistingDash(currentCar);
        int number = RandomNumberService.pickNumber();
        currentCar.move(number);
    }

    private void ranking() {
        winners = new ArrayList<>();
        int max = findMax();
        findWinners(max);
        OutputView.printWinners(winners);
    }

    private int findMax() {
        int max = INT_MIN.getNumber();
        for (int i = ZERO.getNumber(); i < cars.length(); i++) {
            int currentPosition = getCurrentPosition(i);
            if (max < getCurrentPosition(i)) {
                max = currentPosition;
            }
        }
        return max;
    }

    private void findWinners(int max) {
        for (int i = ZERO.getNumber(); i < cars.length(); i++) {
            if (max == getCurrentPosition(i)) {
                winners.add(cars.get(i).getName());
            }
        }
    }

    private String[] splitNames(String input) {
        return input.split(COMMA.getSymbol());
    }

    private void printExistingDash(Car currentCar) {
        for (int position = ZERO.getNumber(); position < currentCar.getPosition(); position++) {
            OutputView.printDash();
        }
    }

    private Car getCar(int i) {
        return cars.get(i);
    }

    private Car getCar(String name) {
        return cars.get(name);
    }

    private int getCurrentPosition(int i) {
        return getCar(i).getPosition();
    }

}
