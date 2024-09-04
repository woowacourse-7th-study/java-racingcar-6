package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.UserInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Race {
    String[] carNames;
    Integer rounds;
    Cars cars;
    List<String> winners;

    public void setup() {
        String input = requestCarNames();
        validateCarNames(input);
        carNames = splitNames(input);

        input = requestRounds();
        validateRounds(input);
        rounds = parseInt(input);
    }

    public void init() {
        cars = new Cars();
        cars.createCars(carNames);
    }

    public void start() {
        raceRounds();
    }

    public void ranking() {
        int max = findMax();
        findWinners(max);
        printWinners(winners);
    }

    private String requestCarNames() {
        OutputView.requestCarNames();
        return InputView.requestCarNames();
    }

    private String requestRounds() {
        OutputView.requestRounds();
        return InputView.requestRounds();
    }

    private void validateCarNames(String input) {
        UserInputValidator.validateCarNames(input);
    }

    private void validateRounds(String input) {
        UserInputValidator.validateRounds(input);
    }

    private String[] splitNames(String input) {
        return input.split(",");
    }

    private int parseInt(String input) {
        return Integer.parseInt(input);
    }

    private void raceRounds() {
        printProcessMessage();
        for (int round = 0; round < rounds; round++) {
            raceEachCar();
            OutputView.newLine();
        }
    }

    private void printProcessMessage() {
        OutputView.printProcess();
    }

    private void raceEachCar() {
        for (String carName : carNames) {
            race(carName);
            OutputView.newLine();
        }
    }

    private void race(String carName) {
        OutputView.printCarName(carName);
        Car currentCar = getCar(carName);
        printExistingDash(currentCar);
        currentCar.race();
    }

    private void printExistingDash(Car currentCar) {
        for (int position = 0; position < currentCar.getPosition(); position++) {
            OutputView.printDash();
        }
    }

    private int findMax() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < cars.length(); i++) {
            int currentPosition = getCurrentPosition(i);
            if (max < getCurrentPosition(i)) {
                max = currentPosition;
            }
        }
        return max;
    }

    private void findWinners(int max) {
        for (int i = 0; i < cars.length(); i++) {
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
