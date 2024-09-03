package racingcar.exception;

public class InputCarNamesValidator {
    public static void validateName(String carName) { // 입력 유효성 검사
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }
}
