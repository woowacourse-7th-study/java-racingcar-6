package racingcar.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputCarNamesValidator {

    public static void validateCarNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(); // 중복 확인을 위한 Set

        for (String carName : carNames) {
            String trimmedName = carName.trim();
            validateCarName(trimmedName);  // 이름 앞뒤의 공백을 제거한 후 유효성 검사

            if (!uniqueNames.add(trimmedName)) { // Set에 추가되지 않으면 중복된 것임
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다: " + trimmedName);
            }
        }
    }

    private static void validateCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }
}
