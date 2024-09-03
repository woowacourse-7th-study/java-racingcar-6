package racingcar.exception;

public class InputCarNamesValidator {
    public static void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            validateCarName(carName.trim());  // 이름 앞뒤의 공백을 제거한 후 유효성 검사
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
