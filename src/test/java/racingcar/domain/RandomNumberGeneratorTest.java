package domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RandomNumberGenerator;

public class RandomNumberGeneratorTest {
    private static final int RANDOM_NUM_MIN = 0;
    private static final int RANDOM_NUM_MAX = 9;

    @Test
    @DisplayName("0부터 9까지 숫자가 발생하는 지 검증")
    void 범위_숫자_확인_테스트() throws Exception {
        //given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        //when, then
        for (int i = 0; i < 100; i++) {
            int randomNum = randomNumberGenerator.generate();
            assertTrue(randomNum >= RANDOM_NUM_MIN);
            assertTrue(randomNum <= RANDOM_NUM_MAX);
        }
    }
}
