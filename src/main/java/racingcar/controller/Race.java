package racingcar.controller;

import racingcar.service.UserInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {
    String carNames;
    Integer rounds;

    public Race() {

    }

    public void setUp() {
        OutputView.requestCarNames();
        carNames = InputView.requestCarNames();
        UserInputValidator.validateCarNames(carNames);

        OutputView.requestRounds();
        String rounds = InputView.requestRounds();
        UserInputValidator.validateRounds(rounds);
        this.rounds = Integer.parseInt(rounds);
    }
}
