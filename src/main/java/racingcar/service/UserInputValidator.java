package racingcar.service;

public class UserInputValidator {
    private UserInputValidator() {
    }

    public static void validateCarNames(String input) {
        checkEmpty(input);

        String carNames = input.strip();

        checkStrip(input, carNames);
        checkContainComma(carNames);

        String[] names = carNames.split(",");

        checkLength(names);
    }

    public static void validateRounds(String input) {
        checkEmpty(input);

        String rounds = input.strip();

        checkStrip(input, rounds);

        checkInt(rounds);
    }

    private static void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("공백 입력은 불가능합니다.");
        }
    }

    private static void checkStrip(String input, String stripped) {
        if (!stripped.equals(input)) {
            throw new IllegalArgumentException("문장 맨 앞과 맨 뒤에 공백 입력은 불가능합니다.");
        }
    }

    private static void checkContainComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("\",\"를 기준으로 자동차의 이름을 나누어 입력해주세요.");
        }
    }

    private static void checkLength(String[] input) {
        for (String name : input) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static void checkInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("시도할 횟수는 정수를 입력해주세요.");
        }
    }

}
