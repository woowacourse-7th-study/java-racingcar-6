package racingcar;

import racingcar.controller.Race;

public class Application {
    public static void main(String[] args) {
        Race race = new Race();
        race.setup();
        race.init();
        race.start();
        race.ranking();
    }
}