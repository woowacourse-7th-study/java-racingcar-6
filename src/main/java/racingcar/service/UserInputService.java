package racingcar.service;

import racingcar.view.InputView;

public class UserInputService {
    private UserInputService() {
    }

    public static String requestCarNames() {
        return InputView.requestCarNames();
    }

    public static String requestRounds() {
        return InputView.requestRounds();
    }
}
