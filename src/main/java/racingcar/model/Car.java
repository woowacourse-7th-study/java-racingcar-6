package racingcar.model;

public class Car {
    private final String name;
    private int distance = 0;

    public Car(final String name) {
        this.name = name;
    }

    public void moveForward(Movable movable) { // 전진 조건
        if (movable.canMove()) {
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
