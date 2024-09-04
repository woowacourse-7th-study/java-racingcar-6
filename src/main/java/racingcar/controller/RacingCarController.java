package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
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
        // 1. 자동차 이름 입력받기
        final List<String> carNames = inputView.inputCarNames();

        // 2. 자동차 객체 리스트 생성 및 Cars 객체로 관리
        Cars cars = new Cars(carNames.stream()
                .map(Car::new) // Car 객체 생성
                .collect(Collectors.toList())); // List<Car>로 변환

        // 3. 라운드 수 입력받기
        final int round = inputView.inputRound();

        // 4. RacingGame 객체 생성
        RacingGame racingGame = new RacingGame();

        // 5. "실행 결과" 출력
        outputView.printResultNotice();

        // 6. 각 라운드를 진행하고 결과 출력
        for (int i = 0; i < round; i++) {
            racingGame.startRound(cars);  // 각 라운드를 RacingGame에서 처리
            outputView.printRoundResult(cars.getCars());  // Cars 클래스에서 자동차 리스트 가져와서 출력
        }

        // 7. 우승자 계산 및 출력
        int maxDistance = cars.getMaxDistance(); // Cars 클래스에서 최대 거리 계산
        List<Car> winners = cars.getWinners(maxDistance); // 우승자 가져오기
        outputView.printWinners(winners); // 우승자 출력
    }
}
