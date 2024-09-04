package racingcar.constant;

public class ErrorMessage {
    private ErrorMessage() {} // 인스턴스화 방지

    public static final String INPUT_CAR_NAMES_MIN = "자동차 이름은 최소 2개 이상이어야 합니다.";
    public static final String INVALID_CAR_NAMES_UNIQUE = "자동차 이름은 중복될 수 없습니다.";
    public static final String INPUT_CAR_NAME_NULL = "자동차 이름은 공백일 수 없습니다.";
    public static final String INVALID_CAR_NAME_MIN = "자동차 이름은 5자 이하만 가능합니다.";

    public static final String INPUT_BLANK = "빈 값을 입력하였습니다.";
    public static final String INPUT_NOT_INTEGER = "유효한 숫자를 입력하세요.";
    public static final String INVALID_NEGATIVE = "시도 횟수는 1 이상이어야 합니다.";

}
