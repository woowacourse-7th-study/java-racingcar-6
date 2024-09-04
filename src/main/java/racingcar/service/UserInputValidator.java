package racingcar.service;

import racingcar.exception.UserInputException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.constant.Symbol.COMMA;
import static racingcar.exception.errorcode.UserInputErrorCode.*;

public class UserInputValidator {
    private UserInputValidator() {
    }

    public static void validateCarNames(String input) {
        checkEmpty(input);

        String carNames = input.strip();

        checkStrip(input, carNames);
        checkContainComma(carNames);

        String[] names = carNames.split(COMMA.getSymbol());

        checkDuplication(names);
        checkLength(names);
    }

    public static void validateRounds(String input) {
        checkEmpty(input);

        String rounds = input.strip();

        checkStrip(input, rounds);
        checkInt(rounds);
        checkMin(rounds);
    }

    private static void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new UserInputException(INPUT_VALUE_BLANK);
        }
    }

    private static void checkStrip(String input, String stripped) {
        if (!stripped.equals(input)) {
            throw new UserInputException(INPUT_VALUE_BLANK_FIRST_LAST);
        }
    }

    private static void checkContainComma(String input) {
        if (!input.contains(",")) {
            throw new UserInputException(INPUT_VALUE_NOT_CONTAIN_COMMA);
        }
    }

    private static void checkDuplication(String[] names) {
        List<String> nameList = Arrays.asList(names);
        Set<String> nameSet = new HashSet<>(nameList);
        if (nameList.size() != nameSet.size()) {
            throw new UserInputException(DUPLICATED_CAR_NAME);
        }
    }

    private static void checkLength(String[] input) {
        for (String name : input) {
            if (name.length() > 5) {
                throw new UserInputException(INVALID_CAR_NAME_LENGTH);
            }
        }
    }

    private static void checkInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new UserInputException(INPUT_VALUE_NOT_NUMERIC);
        }
    }

    private static void checkMin(String input) {
        int rounds = Integer.parseInt(input);
        if (rounds < 1) {
            throw new UserInputException(INVALID_TOTAL_ROUND_RANGE);
        }
    }

}
