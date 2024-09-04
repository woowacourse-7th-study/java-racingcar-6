package racingcar.model;

public class Car {
    private static final int MOVE_FORWARD_LOWER_BOUND = 4; // 전진 조건
    private final String name;
    private int distance = 0;

    public Car(final String name) {
        this.name = name;
    }

    public void moveForward(final int condition) { // 전진 조건
        if (condition >= MOVE_FORWARD_LOWER_BOUND) {
            distance++;
        }
    }

    public String getCarName() { // carName 반환
        return this.name;
    }

    public Integer getDistance() { // 현재 거리 반환
        return this.distance;
    }

}
