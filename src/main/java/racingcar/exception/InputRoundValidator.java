package racingcar.exception;

import static racingcar.constant.ErrorMessage.*;

public class InputRoundValidator {
    public static final int TRIAL_TIME_MIN = 0;
    public static void validateRound(String input) { // 시도 횟수 유효성 검사
        if (input == null || input.isEmpty()) { // 입력이 null이거나 빈 문자열인 경우
            throw new IllegalArgumentException(INPUT_BLANK);
        }

        for (char c : input.toCharArray()) { // 입력값이 숫자가 아닌 문자를 포함하는 경우
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(INPUT_NOT_INTEGER);
            }
        }

        if (Integer.parseInt(input) <= TRIAL_TIME_MIN) { // 시도 횟수가 0 이하인 경우
            throw new IllegalArgumentException(INVALID_NEGATIVE);
        }
    }
}
