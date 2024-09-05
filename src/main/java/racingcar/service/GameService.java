package racingcar.service;

import racingcar.domain.Movable;
import racingcar.domain.model.Car;
import racingcar.domain.model.Cars;

import java.util.List;

public class GameService {
    // 각 라운드를 진행하는 메서드
    public void startRound(Cars cars) {
        cars.updateRaceRound(new Movable()); // Cars에서 각 자동차의 라운드를 진행
    }

    // 우승자를 계산하는 메서드
    public List<Car> chooseWinners(Cars cars) {
        int maxDistance = cars.getMaxDistance();  // 최대 거리 계산
        return cars.getWinners(maxDistance);      // 최대 거리에 도달한 우승자 가져오기
    }
}
