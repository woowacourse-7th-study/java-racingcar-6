package racingcar.exception;

public class InputRoundValidator {
    public static void validateRound(String input) { // 시도 횟수 유효성 검사
        if (input == null || input.isEmpty()) { // 입력이 null이거나 빈 문자열인 경우
            throw new IllegalArgumentException("시도 횟수를 입력하세요.");
        }

        for (char c : input.toCharArray()) { // 입력값이 숫자가 아닌 문자를 포함하는 경우
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("유효한 숫자를 입력하세요.");
            }
        }

        if (Integer.parseInt(input) <= 0) { // 시도 횟수가 0 이하인 경우
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
