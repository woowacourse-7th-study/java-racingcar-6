package racingcar.domain.dto;

import racingcar.domain.model.Car;
import racingcar.domain.model.Cars;

import java.util.List;

public class CarsDTO {
    private Cars cars;

    public CarsDTO() {
    }

    // 자동차 이름 리스트로 Cars 객체를 생성하는 메서드 추가
    public CarsDTO(List<String> carNames) {
        this.cars = new Cars(carNames.stream()
                .map(Car::new)
                .toList());
    }

    public Cars getCars() {
        return cars;
    }
}
