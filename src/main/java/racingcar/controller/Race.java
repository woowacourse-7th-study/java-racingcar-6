package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.UserInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.Range.*;
import static racingcar.constant.Symbol.COMMA;

public class Race {
    String[] carNames;
    Integer rounds;
    Cars cars;
    List<String> winners;

    public void run() {
        setup();
        init();
        start();
        ranking();
    }

    private void setup() {
        String input = requestCarNames();
        validateCarNames(input);
        carNames = splitNames(input);

        input = requestRounds();
        validateRounds(input);
        rounds = parseInt(input);
    }

    private void init() {
        cars = new Cars();
        cars.createCars(carNames);
    }

    private void start() {
        raceRounds();
    }

    private void ranking() {
        winners = new ArrayList<>();
        int max = findMax();
        findWinners(max);
        printWinners(winners);
    }

    private String requestCarNames() {
        return InputView.requestCarNames();
    }

    private String requestRounds() {
        return InputView.requestRounds();
    }

    private void validateCarNames(String input) {
        UserInputValidator.validateCarNames(input);
    }

    private void validateRounds(String input) {
        UserInputValidator.validateRounds(input);
    }

    private String[] splitNames(String input) {
        return input.split(COMMA.getSymbol());
    }

    private int parseInt(String input) {
        return Integer.parseInt(input);
    }

    private void raceRounds() {
        printProcessMessage();
        for (int round = ZERO.getNumber(); round < rounds; round++) {
            raceEachCar();
            System.out.println();
        }
    }

    private void printProcessMessage() {
        OutputView.printProcess();
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
        int number = pickNumber();
        currentCar.move(number);
    }

    private void printExistingDash(Car currentCar) {
        for (int position = ZERO.getNumber(); position < currentCar.getPosition(); position++) {
            OutputView.printDash();
        }
    }

    public int pickNumber() {
        return Randoms.pickNumberInRange(RANDOM_RANGE_MIN.getNumber(), RANDOM_RANGE_MAX.getNumber());
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

    private void printWinners(List<String> winners) {
        OutputView.printWinners(winners);
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
