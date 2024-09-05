package racingcar.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.constant.ErrorMessage.*;

public class InputCarNamesValidator {

    public static final int CAR_NAMES_MIN = 2;
    public static final int CAR_NAME_MAX = 5;

    public static void validateCarNames(List<String> carNames) {
        // 자동차 이름이 1개 이하일 경우 예외 발생
        if (carNames.size() < CAR_NAMES_MIN) {
            throw new IllegalArgumentException(INPUT_CAR_NAMES_MIN);
        }
        // 자동차 이름이 중복되는 경우 예외 발생
        Set<String> uniqueNames = new HashSet<>(); // 중복 확인을 위한 Set

        for (String carName : carNames) {
            String trimmedName = carName.trim();
            validateCarName(trimmedName);  // 이름 앞뒤의 공백을 제거한 후 유효성 검사

            if (!uniqueNames.add(trimmedName)) { // Set에 추가되지 않으면 중복된 것임
                throw new IllegalArgumentException(INVALID_CAR_NAMES_UNIQUE);
            }
        }
    }

    private static void validateCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_NULL);
        }
        if (carName.length() > CAR_NAME_MAX) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MIN);
        }
    }
}
