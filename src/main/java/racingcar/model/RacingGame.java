package racingcar.model;

import java.util.List;

public class RacingGame {

    private final Cars cars;

    // 생성자에서 Cars 객체를 생성함
    public RacingGame(List<Car> carList) {
        this.cars = new Cars(carList);
    }

    // 라운드 진행 메서드
    public void startRounds(final int roundCounts) {
        for (int i = 0; i < roundCounts; i++) {
            List<Car> updatedCars = cars.updateRaceRound();  // 각 라운드마다 자동차 상태 업데이트
        }
    }

}
