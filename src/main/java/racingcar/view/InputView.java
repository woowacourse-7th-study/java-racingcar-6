package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.constant.Message.ENTER_CAR_NAMES;
import static racingcar.constant.Message.ENTER_ROUNDS;

public class InputView {
    private InputView() {
    }

    public static String requestCarNames() {
        System.out.println(ENTER_CAR_NAMES.getMessage());
        return Console.readLine();
    }

    public static String requestRounds() {
        System.out.println(ENTER_ROUNDS.getMessage());
        return Console.readLine();
    }
}