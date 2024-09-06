package racingcar.domain;

public class Movable {
    private static final int MOVE_FORWARD_LOWER_BOUND = 4; // 전진 조건
    private final RandomNumberGenerator randomNumberGenerator;

    public Movable() {
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public Movable(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    // 전진 조건을 만족하면 true를 반환하는 메서드
    public boolean canMove() { // 전진 조건을 만족하면 true 반환
        return MOVE_FORWARD_LOWER_BOUND <= randomNumberGenerator.generate();
    }
}
