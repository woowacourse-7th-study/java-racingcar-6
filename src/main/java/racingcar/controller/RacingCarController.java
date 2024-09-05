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
    private RacingGame racingGame;
    private Cars cars;
    private int round;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        // 1. 자동차 이름 입력받기
        inputCarNames();

        // 2. 라운드 수 입력받기
        inputRoundCount();

        // 3. RacingGame 객체 생성 및 결과 출력
        startGame();

        // 4. 우승자 계산 및 출력
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
        racingGame = new RacingGame(); // RacingGame 객체 생성

        outputView.printResultNotice(); // "실행 결과" 출력

        for (int i = 0; i < round; i++) {
            racingGame.startRound(cars); // 각 라운드 진행
            outputView.printRoundResult(cars.getCars()); // 각 라운드 결과 출력
        }
    }

    // 우승자 계산 및 출력
    private void printWinners() {
        int maxDistance = cars.getMaxDistance(); // 최대 거리 계산
        List<Car> winners = cars.getWinners(maxDistance); // 우승자 가져오기
        outputView.printWinners(winners); // 우승자 출력
    }
}
