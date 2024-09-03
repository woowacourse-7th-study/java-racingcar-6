package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args){
        playGame();
    }
    private static void playGame(){ // 게임 시작 문구 출력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCars(); // 자동차 이름을 입력받는 메서드 호출
        System.out.println("시도할 회수는 몇 회인가요?");
    }

    private static void inputCars(){ // 자동차 이름을 입력 받음
        String input = Console.readLine();
        splitInput(input);
    }
    private static void splitInput(String input){ // 쉼표를 기준으로 자동차 이름을 입력 받음
        // 입력된 문자열을 쉼표로 분리하여 배열에 저장
        String[] carNames = input.split(",", -1); // split은 정규표현식 기반이므로 빈 문자열은 무시함 -> -1을 인자로 전달하여 빈 문자열도 포함시키기

        System.out.println(carNames.length);
        for (int i=0; i<carNames.length; i++){ // 입력받은 carNames 만큼 반복하고, 유효성 검사 진행
            System.out.println(carNames[i]);
            validateInput(carNames[i].trim());  // 이름 앞뒤의 공백을 제거
        }
    }

    private static void validateInput(String carName){ // 입력 유효성 검사
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
        if(carName.length() > 5){
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }
}
