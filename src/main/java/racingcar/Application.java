package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.UserInputValidator;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.inputCarNames();
        String carNames = Console.readLine();
        UserInputValidator.validateCarNames(carNames);

        OutputView.inputRounds();
        String rounds = Console.readLine();
        UserInputValidator.validateRounds(rounds);
    }
}