package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingCarController;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        new RacingCarController().run();
    }
}
