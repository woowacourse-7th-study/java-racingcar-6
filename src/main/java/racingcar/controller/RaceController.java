package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.FindWinnerService;
import racingcar.service.RandomNumberService;
import racingcar.service.UserInputService;
import racingcar.service.UserInputValidator;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.constant.Range.ZERO;
import static racingcar.constant.Symbol.COMMA;

public class RaceController {
    String[] carNames;
    Integer rounds;
    Cars cars;
    List<String> winners;

    public void run() {
        setup();
        init();
        raceRounds();
        ranking();
    }

    private void setup() {
        String input = UserInputService.requestCarNames();
        UserInputValidator.validateCarNames(input);
        carNames = input.split(COMMA.getSymbol());

        input = UserInputService.requestRounds();
        UserInputValidator.validateRounds(input);
        rounds = Integer.parseInt(input);
    }

    private void init() {
        cars = new Cars();
        cars.createCars(carNames);
    }

    private void raceRounds() {
        OutputView.printProcess();
        for (int round = ZERO.getNumber(); round < rounds; round++) {
            raceEachCar();
            System.out.println();
        }
    }

    private void raceEachCar() {
        for (String carName : carNames) {
            race(carName);
            System.out.println();
        }
    }

    private void race(String carName) {
        OutputView.printCarName(carName);
        Car currentCar = FindWinnerService.getCar(cars, carName);
        for (int position = ZERO.getNumber(); position < currentCar.getPosition(); position++) {
            OutputView.printDash();
        }
        int number = RandomNumberService.pickNumber();
        currentCar.move(number);
    }

    private void ranking() {
        int max = FindWinnerService.findMax(cars);
        winners = FindWinnerService.findWinners(cars, max);
        OutputView.printWinners(winners);
    }
}
