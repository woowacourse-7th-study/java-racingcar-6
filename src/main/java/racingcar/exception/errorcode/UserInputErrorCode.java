package racingcar.exception.errorcode;

import static racingcar.constant.Range.CAR_NAME_LENGTH_LIMIT;
import static racingcar.constant.Range.ROUND_MIN;

public enum UserInputErrorCode {
    INPUT_VALUE_BLANK("입력값은 공백일 수 없습니다."),
    INPUT_VALUE_BLANK_FIRST_LAST("문장 맨 앞과 맨 뒤는 공백일 수 없습니다."),
    INPUT_VALUE_NOT_NUMERIC("입력값은 숫자여야 합니다."),
    INPUT_VALUE_NOT_CONTAIN_COMMA("\",\"를 기준으로 자동차의 이름을 나누어 입력해야 합니다."),
    DUPLICATED_CAR_NAME("자동차 이름은 중복일 수 없습니다."),
    INVALID_CAR_NAME_LENGTH("자동차 이름은 최대 " + CAR_NAME_LENGTH_LIMIT.getNumber() + "자까지 가능합니다."),
    INVALID_TOTAL_ROUND_RANGE("라운드는 최소 " + ROUND_MIN + "회 이상이여야 합니다.");

    private final String message;

    UserInputErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
