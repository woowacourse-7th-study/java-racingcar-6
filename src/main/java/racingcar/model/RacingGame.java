package racingcar.model;

import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {

    private final Cars cars;

    public RacingGame(List<Car> carList) { // 생성자에서 Cars 객체를 생성함
        this.cars = new Cars(carList);
    }

    public List<Car> startRound() { // 라운드 진행 메서드
        return cars.updateRaceRound();  // 각 라운드마다 자동차 상태 업데이트 후 반환
    }

}
