package domain.view;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

public class InputRoundTest {
    private final InputView inputView = new InputView();

    @Test
    @DisplayName("문자열로 입력된 입력 횟수가 숫자로 변환이 되었는지 검증")
    public void 입력_횟수_스트링_숫자_변환_테스트() throws Exception {
        // given
        String input = "5";
        // when
        int progressCount = inputView.inputRoundForTest(input);
        // then
        Assertions.assertEquals(5, progressCount);
    }

    @Test
    @DisplayName("입력이 정수가 아닌 경우 예외 발생 검증")
    public void 문자열_입력_예외_테스트() throws Exception {
        // given
        String invalidInput = "invalid";
        // then
        assertThrows(IllegalArgumentException.class, () -> inputView.inputRoundForTest(invalidInput));
    }

    @Test
    @DisplayName("0보다 작은 입력이 들어오는 경우 예외 발생 검증")
    public void 범위를_초과하는_입력_예외_테스트() throws Exception {
        // given
        String invalidInput = "0";
        // then
        assertThrows(IllegalArgumentException.class, () -> inputView.inputRoundForTest(invalidInput));
    }
}
