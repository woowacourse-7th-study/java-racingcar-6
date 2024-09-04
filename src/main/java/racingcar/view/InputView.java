package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {
    }

    public static String requestCarNames() {
        return readLine();
    }

    public static String requestRounds() {
        return readLine();
    }

    private static String readLine() {
        return Console.readLine();
    }
}