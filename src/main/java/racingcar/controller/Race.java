package racingcar.controller;

import racingcar.service.UserInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {

    static String carNames;
    static String rounds;

    public Race() {

    }

    public void setUp() {
        OutputView.requestCarNames();
        carNames = InputView.requestCarNames();
        UserInputValidator.validateCarNames(carNames);

        OutputView.requestRounds();
        rounds = InputView.requestRounds();
        UserInputValidator.validateRounds(rounds);
    }
}
