package racingcar.domain;

import racingcar.domain.model.Cars;

public class RacingGame {
    public void startRound(Cars cars) {
        cars.updateRaceRound(new Movable()); // Cars에서 각 자동차의 라운드를 진행
    }
}
