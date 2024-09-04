package racingcar.view;

import java.util.List;

import static racingcar.constant.Message.*;
import static racingcar.constant.Symbol.*;

public class OutputView {
    private OutputView() {

    }

    public static void requestCarNames() {
        System.out.println(ENTER_CAR_NAMES.getMessage());
    }

    public static void requestRounds() {
        System.out.println(ENTER_ROUNDS.getMessage());
    }

    public static void printProcess() {
        System.out.println(PROCESSING_MESSAGE.getMessage());
    }

    public static void printCarName(String name) {
        System.out.print(name + BLANK.getSymbol() + COLON.getSymbol() + BLANK.getSymbol());
    }

    public static void printDash() {
        System.out.print(DASH.getSymbol());
    }

    public static void newLine() {
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(PRINT_WINNERS.getMessage() + String.join(COMMA.getSymbol() + BLANK.getSymbol(), winners));
    }

}
