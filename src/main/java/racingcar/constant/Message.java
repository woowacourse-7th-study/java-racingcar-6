package racingcar.constant;

public enum Message {
    ENTER_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ENTER_ROUNDS("시도할 회수는 몇회인가요?"),
    PROCESSING_MESSAGE("실행 결과"),
    PRINT_WINNERS("최종 우승자 : ");

    final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}