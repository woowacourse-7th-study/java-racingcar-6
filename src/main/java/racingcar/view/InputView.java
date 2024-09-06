package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InputCarNamesValidator;
import racingcar.exception.InputRoundValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constant.ViewMessage.INPUT_CAR_NAME;
import static racingcar.constant.ViewMessage.INPUT_TRIAL_COUNT;

public class InputView {
    public static final String CAR_NAMES_DILIMITER = ",";

    public List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAME);
        String carNames = Console.readLine();
        return processCarNames(carNames);
    }

    public List<String> inputCarNamesForTest(String carNames) { // 테스트에서 사용할 입력 메서드
        return processCarNames(carNames);
    }

    private List<String> processCarNames(String carNames) {  // 입력된 자동차 이름을 처리하는 로직 분리
        List<String> carNamesList = splitInput(carNames);
        InputCarNamesValidator.validateCarNames(carNamesList); // 유효성 검사
        return carNamesList;
    }

    private List<String> splitInput(String names) { // 쉼표를 기준으로 리스트로 변환
        return Arrays.stream(names.split(CAR_NAMES_DILIMITER, -1)) // 쉼표를 기준으로 쪼개고
                .map(String::trim) // 각 이름의 앞뒤 공백 제거
                .collect(Collectors.toList()); // 리스트로 변환하여 반환
    }

    public int inputRound() { // 시도 횟수 입력 받기
        System.out.println(INPUT_TRIAL_COUNT);
        String input = Console.readLine();
        InputRoundValidator.validateRound(input); // 유효성 검사 및 변환
        int round = Integer.parseInt(input); // 문자열을 정수로 변환

        return round;
    }

}
