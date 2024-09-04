package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.UserInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {
    String carNames;
    String[] names;
    Integer rounds;
    Cars cars;

    public Race() {

    }

    public void setUp() {
        OutputView.requestCarNames();
        carNames = InputView.requestCarNames();
        UserInputValidator.validateCarNames(carNames);
        this.names = carNames.split(",");

        OutputView.requestRounds();
        String rounds = InputView.requestRounds();
        UserInputValidator.validateRounds(rounds);
        this.rounds = Integer.parseInt(rounds);
    }

    public void init() {
        cars = new Cars();
        cars.createCars(names);
    }

    public void start() {
        System.out.println("실행 결과");
        for (int round = 0; round < rounds; round++) {
            for (String name : names) {
                System.out.print(name + " : ");
                Car currentCar = cars.get(name);
                for (int position = 0; position < currentCar.getPosition(); position++) {
                    System.out.print("-");
                }
                currentCar.race();
                System.out.println();
            }
            System.out.println();
        }
    }
}
