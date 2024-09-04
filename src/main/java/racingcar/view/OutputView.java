package racingcar.view;

import java.util.List;

import static racingcar.constant.Message.*;

public class OutputView {
    private OutputView() {

    }

    public static void requestCarNames() {
        System.out.println(ENTER_CAR_NAMES);
    }

    public static void requestRounds() {
        System.out.println(ENTER_ROUNDS);
    }

    public static void printProcess() {
        System.out.println(PROCESSING_MESSAGE);
    }

    public static void printCarName(String name) {
        System.out.print(name + " : ");
    }

    public static void printDash() {
        System.out.print("-");
    }

    public static void newLine() {
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(PRINT_WINNERS + String.join("," + " ", winners));
    }

}
