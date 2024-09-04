package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public void printResultNotice() {
        System.out.println("실행 결과");
    }

    public void printRoundResult(List<Car> updatedCars) { // 라운드 결과를 출력하는 메서드
        updatedCars.forEach(car ->
                System.out.println(car.getCarName() + " : " + "-".repeat(car.getDistance()))
        );
        System.out.println();  // 라운드마다 결과 구분을 위한 빈 줄 출력
    }
}
