package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.UserInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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

    private void printExistingDash(Car currentCar) {
        for (int position = 0; position < currentCar.getPosition(); position++) {
            OutputView.printDash();
        }
    }
}
