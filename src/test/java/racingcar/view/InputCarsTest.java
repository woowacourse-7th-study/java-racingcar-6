package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

public class InputCarsTest {

    // InputView 객체 생성
    private final InputView inputView = new InputView();

    @Test
    @DisplayName("자동차가 순차적으로 저장이 되는지 검증")
    public void 자동차_입력_테스트() throws Exception {
        //given
        String carNames = "pobi,woni,jun"; // 입력값
        //when
        List<String> parsedCarList = inputView.inputCarNamesForTest(carNames); // 입력값을 InputView로 처리
        //then
        assertEquals("pobi", parsedCarList.get(0));
        assertEquals("woni", parsedCarList.get(1));
        assertEquals("jun", parsedCarList.get(2));
    }

    @Test
    @DisplayName("자동차 리스트에 공백이 존재하면 안 된다.")
    public void 자동차_공백_테스트() throws Exception {
        String carNames = "pobi, ,jun"; // 공백이 포함된 이름
        assertThrows(IllegalArgumentException.class, () -> inputView.inputCarNamesForTest(carNames));
    }

    @Test
    @DisplayName("자동차 리스트에 5글자를 넘어가는 자동차가 존재하면 안 된다.")
    public void 자동차_이름_초과_테스트() throws Exception {
        String carNames = "pobi,seokhwan,jun"; // 이름이 5글자 초과
        assertThrows(IllegalArgumentException.class, () -> inputView.inputCarNamesForTest(carNames));
    }

    @Test
    @DisplayName("자동차 리스트에 중복이 존재하면 안 된다.")
    public void 자동차_중복_테스트() throws Exception {
        String carNames = "pobi,pobi,jun"; // 중복 이름
        assertThrows(IllegalArgumentException.class, () -> inputView.inputCarNamesForTest(carNames));
    }
}
