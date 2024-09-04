package racingcar.constant;

public enum Range {
    ZERO(0),
    INT_MIN(Integer.MIN_VALUE),
    RANDOM_RANGE_MIN(0),
    RANDOM_RANGE_MAX(9),
    FORWARD_MIN(4),
    CAR_NAME_LENGTH_LIMIT(5),
    ROUND_MIN(1);

    final int number;

    Range(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
