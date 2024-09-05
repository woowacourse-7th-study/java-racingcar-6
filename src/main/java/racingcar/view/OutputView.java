package racingcar.view;

import racingcar.domain.model.Car;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constant.ViewMessage.*;

public class OutputView {

    public void printResultNotice() {
        System.out.println(GAME_RESULT);
    }

    public void printRoundResult(List<Car> updatedCars) { // 라운드 결과를 출력하는 메서드
        updatedCars.forEach(car ->
                System.out.println(car.getCarName() + " : " + "-".repeat(car.getDistance()))
        );
        System.out.println();  // 라운드마다 결과 구분을 위한 빈 줄 출력
    }

    public void printWinners(final List<Car> cars) {
        String winners = cars.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(WINNER_RESULT_DELIMITER));

        System.out.println(WINNER_RESULT_FORMAT + winners);
    }
}
