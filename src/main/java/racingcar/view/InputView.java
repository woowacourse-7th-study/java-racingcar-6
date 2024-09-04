package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {
    }

    public static String requestCarNames() {
        return Console.readLine();
    }

    public static String requestRounds() {
        return Console.readLine();
    }
}