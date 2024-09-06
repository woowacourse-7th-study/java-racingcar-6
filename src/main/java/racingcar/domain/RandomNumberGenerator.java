package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int RANDOM_NUM_MIN = 0;
    private static final int RANDOM_NUM_MAX = 9;

    // 랜덤 넘버 생성하는 메서드
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_NUM_MIN, RANDOM_NUM_MAX);
    }
}
