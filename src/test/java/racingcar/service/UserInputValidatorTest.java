package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.errorcode.UserInputErrorCode;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputValidatorTest {

    @Test
    @DisplayName("자동차 이름에 대한 입력이 null 인 경우 에러가 발생한다.")
    void validateCarNamesNull() {
        // given
        String input = null;

        // when & then
        assertThatThrownBy(() -> UserInputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UserInputErrorCode.INPUT_VALUE_BLANK.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 대한 입력이 빈 문자열인 경우 에러가 발생한다.")
    void validateCarNamesEmpty() {
        // given
        String input = "";

        // when & then
        assertThatThrownBy(() -> UserInputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UserInputErrorCode.INPUT_VALUE_BLANK.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 대한 입력이 공백 문자열인 경우 에러가 발생한다.")
    void validateCarNamesBlank() {
        // given
        String input = " ";

        // when & then
        assertThatThrownBy(() -> UserInputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UserInputErrorCode.INPUT_VALUE_BLANK.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 대한 입력의 맨 앞, 맨 뒤가 공백인 경우 에러가 발생한다.")
    void validateCarNamesStrip() {
        // given
        String input = " abc ";

        // when & then
        assertThatThrownBy(() -> UserInputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UserInputErrorCode.INPUT_VALUE_BLANK_FIRST_LAST.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 대한 입력에 ','가 없는 경우 에러가 발생한다.")
    void validateCarNamesComma() {
        // given
        String input = "abc";

        // when & then
        assertThatThrownBy(() -> UserInputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UserInputErrorCode.INPUT_VALUE_NOT_CONTAIN_COMMA.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 대한 입력이 중복되는 경우 에러가 발생한다.")
    void validateCarNamesDuplication() {
        // given
        String input = "abc,abc";

        // when & then
        assertThatThrownBy(() -> UserInputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UserInputErrorCode.DUPLICATED_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("각 자동차 이름이 5자 이하가 아닌 경우 에러가 발생한다.")
    void validateCarNamesLength() {
        // given
        String input = "abcdef,fgh";

        // when & then
        assertThatThrownBy(() -> UserInputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UserInputErrorCode.INVALID_CAR_NAME_LENGTH.getMessage());
    }

    @Test
    @DisplayName("시도할 횟수에 대한 입력이 null 인 경우 에러가 발생한다.")
    void validateRoundsNull() {
        // given
        String input = null;

        // when & then
        assertThatThrownBy(() -> UserInputValidator.validateRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UserInputErrorCode.INPUT_VALUE_BLANK.getMessage());
    }

    @Test
    @DisplayName("시도할 횟수에 대한 입력이 빈 문자열인 경우 에러가 발생한다.")
    void validateRoundsEmpty() {
        // given
        String input = "";

        // when & then
        assertThatThrownBy(() -> UserInputValidator.validateRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UserInputErrorCode.INPUT_VALUE_BLANK.getMessage());
    }

    @Test
    @DisplayName("시도할 횟수에 대한 입력이 빈 문자열인 경우 에러가 발생한다.")
    void validateRoundsBlank() {
        // given
        String input = " ";

        // when & then
        assertThatThrownBy(() -> UserInputValidator.validateRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UserInputErrorCode.INPUT_VALUE_BLANK.getMessage());
    }

    @Test
    @DisplayName("시도할 횟수에 대한 입력의 맨 앞, 맨 뒤가 공백인 경우 에러가 발생한다.")
    void validateRoundsStrip() {
        // given
        String input = " 1 ";

        // when & then
        assertThatThrownBy(() -> UserInputValidator.validateRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UserInputErrorCode.INPUT_VALUE_BLANK_FIRST_LAST.getMessage());
    }

    @Test
    @DisplayName("시도할 횟수에 대한 입력이 정수가 아닌 경우 에러가 발생한다.")
    void validateRoundsInt() {
        // given
        String input = "testString";

        // when & then
        assertThatThrownBy(() -> UserInputValidator.validateRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UserInputErrorCode.INPUT_VALUE_NOT_NUMERIC.getMessage());
    }

    @Test
    @DisplayName("시도할 횟수에 대한 입력이 1보다 작은 경우 에러가 발생한다.")
    void validateRoundsMin() {
        // given
        String input = "0";

        // when & then
        assertThatThrownBy(() -> UserInputValidator.validateRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UserInputErrorCode.INVALID_TOTAL_ROUND_RANGE.getMessage());
    }
}