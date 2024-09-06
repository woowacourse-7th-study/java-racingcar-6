package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Movable;
import racingcar.domain.model.Car;

public class CarTest {
    private Car car;

    @BeforeEach
    public void Init() {
        car = new Car("hzlo");
    }

    @Test
    @DisplayName("자동차 생성자 생성 검증")
    public void 자동차_생성자_테스트() throws Exception {
        assertEquals("hzlo", car.getCarName());

        assertEquals(0, car.getDistance());
    }

    @Test
    @DisplayName("자동차의 전진과 정지가 되는지 검증")
    public void 자동차_전진_후진_테스트() throws Exception {
        car.moveForward(new Movable() { // 전진
            @Override
            public boolean canMove() {
                return true;
            }
        });

        assertEquals(1, car.getDistance());

        car.moveForward(new Movable() { // 정지
            public boolean canMove() {
                return false;
            }
        });
        assertEquals(1, car.getDistance());
    }

    @Test
    @DisplayName("자동차 거리에 따른 출력이 되는지 검증")
    public void 자동차_거리_출력_테스트() throws Exception {
        car.moveForward(new Movable() { // 한 번 이동
            @Override
            public boolean canMove() {
                return true;
            }
        });

        assertEquals("-".length(), car.getDistance());

        // 두 번 더 이동
        car.moveForward(new Movable() {
            @Override
            public boolean canMove() {
                return true;
            }
        });
        car.moveForward(new Movable() {
            @Override
            public boolean canMove() {
                return true;
            }
        });
        //then
        assertEquals("---".length(), car.getDistance());
    }
}
