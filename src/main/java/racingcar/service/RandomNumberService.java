package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constant.Range.RANDOM_RANGE_MAX;
import static racingcar.constant.Range.RANDOM_RANGE_MIN;

public class RandomNumberService {
    private RandomNumberService() {
    }

    public static int pickNumber() {
        return Randoms.pickNumberInRange(RANDOM_RANGE_MIN.getNumber(), RANDOM_RANGE_MAX.getNumber());
    }
}
