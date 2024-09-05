package racingcar.controller;

import racingcar.domain.dto.CarsDTO;
import racingcar.domain.model.Car;
import racingcar.domain.model.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGame racingGame;
    private Cars cars;
    private int round;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.racingGame = new RacingGame();
    }

    public void run() {
        inputCarNames();
        inputRoundCount();
        startGame();
        printWinners();
    }

    // 자동차 이름을 입력받아 Cars 객체 생성
    private void inputCarNames() {
        List<String> carNames = inputView.inputCarNames();
        cars = new CarsDTO(carNames).getCars();
    }

    // 라운드 수 입력받기
    private void inputRoundCount() {
        round = inputView.inputRound();
    }

    // 게임 시작 및 결과 출력
    private void startGame() {
        outputView.printResultNotice();

        for (int i = 0; i < round; i++) {
            racingGame.startRound(cars); // 각 라운드 진행
            outputView.printRoundResult(cars.getCars()); // 각 라운드 결과 출력
        }
    }

    // 우승자 계산 및 출력
    private void printWinners() {
        outputView.printWinners(racingGame.chooseWinners(cars)); // 우승자 출력
    }
}
