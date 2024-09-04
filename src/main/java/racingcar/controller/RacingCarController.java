package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        final List<String> carNames = inputView.inputCarNames();
        final int round = inputView.inputRound();
    }

}
