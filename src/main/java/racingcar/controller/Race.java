package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.UserInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Race {
    String carNames;
    String[] names;
    Integer rounds;
    Cars cars;

    public void setup() {
        OutputView.requestCarNames();
        carNames = InputView.requestCarNames();
        UserInputValidator.validateCarNames(carNames);
        this.names = carNames.split(",");

        OutputView.requestRounds();
        String rounds = InputView.requestRounds();
        UserInputValidator.validateRounds(rounds);
        this.rounds = Integer.parseInt(rounds);
    }

    public void init() {
        cars = new Cars();
        cars.createCars(names);
    }

    public void start() {
        OutputView.printProcess();
        for (int round = 0; round < rounds; round++) {
            for (String name : names) {
                OutputView.printCarName(name);
                Car currentCar = cars.get(name);
                printExistingDash(currentCar);
                currentCar.race();
                OutputView.newLine();
            }
            OutputView.newLine();
        }
    }

    public void ranking() {
        List<String> winners = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < cars.length(); i++) {
            int currentPosition = cars.get(i).getPosition();
            if (max < currentPosition) {
                max = currentPosition;
            }
        }
        for (int i = 0; i < cars.length(); i++) {
            int currentPosition = cars.get(i).getPosition();
            if (max == currentPosition) {
                winners.add(cars.get(i).getName());
            }
        }
        OutputView.printWinners(winners);
    }

    private void printExistingDash(Car currentCar) {
        for (int position = 0; position < currentCar.getPosition(); position++) {
            OutputView.printDash();
        }
    }
}
