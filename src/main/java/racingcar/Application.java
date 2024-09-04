package racingcar;

import racingcar.service.UserInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.requestCarNames();
        String carNames = InputView.requestCarNames();
        UserInputValidator.validateCarNames(carNames);

        OutputView.requestRounds();
        String rounds = InputView.requestRounds();
        UserInputValidator.validateRounds(rounds);
    }
}