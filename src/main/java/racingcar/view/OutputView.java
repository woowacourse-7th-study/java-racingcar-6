package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private OutputView() {

    }

    public static void requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void requestRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printProcess() {
        System.out.println("실행 결과");
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
        System.out.println("최종 우승자 : " + String.join("," + " ", winners));
    }

}
