package racingcar.exception;

import racingcar.exception.errorcode.UserInputErrorCode;

public class UserInputException extends IllegalArgumentException {

    public UserInputException(final UserInputErrorCode errorCode) {
        super(errorCode.getMessage());
    }

}
