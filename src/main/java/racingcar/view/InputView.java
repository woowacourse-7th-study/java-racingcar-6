package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InputCarNamesValidator;
import racingcar.exception.InputRoundValidator;

public class InputView {

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        return splitInput(carNames);
    }

    private String[] splitInput(String names) { // 쉼표를 기준으로 자동차 이름을 입력 받음
        // 입력된 문자열을 쉼표로 분리하여 배열에 저장
        String[] carNames = names.split(",", -1); // split은 정규표현식 기반이므로 빈 문자열은 무시함 -> -1을 인자로 전달하여 빈 문자열도 포함시키기

        for (int i = 0; i < carNames.length; i++) { // 입력받은 carNames 만큼 반복하고, 유효성 검사 진행
            System.out.println(carNames[i]);
            InputCarNamesValidator.validateName(carNames[i].trim());  // 이름 앞뒤의 공백을 제거
        }

        return carNames;
    }

    public int inputRound() { // 시도 횟수 입력 받기
        System.out.println("시도할 회수는 몇 회인가요?");
        String input = Console.readLine();
        InputRoundValidator.validateRound(input); // 유효성 검사 및 변환
        int round = Integer.parseInt(input); // 문자열을 정수로 변환

        return round;
    }

}
