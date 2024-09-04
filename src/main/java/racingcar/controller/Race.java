package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.UserInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {
    String carNames;
    String[] names;
    Integer rounds;

    public Race() {

    }

    public void setUp() {
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
        Cars cars = new Cars();
        cars.createCars(names);
    }
}
