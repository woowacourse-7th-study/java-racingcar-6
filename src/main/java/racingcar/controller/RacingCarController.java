package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

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

        List<Car> cars = carNames.stream()
                .map(Car::new) // Car 생성자를 이용해 Car 객체 생성
                .collect(Collectors.toList());

        RacingGame racingGame = new RacingGame(cars);

        outputView.printResultNotice(); // "실행 결과" 출력

        // 각 라운드 진행하고 출력하기
        for (int i = 0; i < round; i++) {
            List<Car> updatedCars = racingGame.startRound(); // 한 라운드 진행
            outputView.printRoundResult(updatedCars);  // 라운드 결과 출력
        }
    }

}
