package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Movable;
import racingcar.domain.model.Car;
import racingcar.domain.model.Cars;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    public void InitCars() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        Car jun = new Car("jun");

        pobi.moveForward(new Movable() {
            @Override
            public boolean canMove() {
                return true;
            }
        });

        pobi.moveForward(new Movable() {
            @Override
            public boolean canMove() {
                return true;
            }
        });

        woni.moveForward(new Movable() {
            @Override
            public boolean canMove() {
                return true;
            }
        });

        woni.moveForward(new Movable() {
            @Override
            public boolean canMove() {
                return true;
            }
        });

        jun.moveForward(new Movable() {
            @Override
            public boolean canMove() {
                return true;
            }
        });

        List<Car> carList = Arrays.asList(pobi, woni, jun);
        cars = new Cars(carList);
    }

    @Test
    @DisplayName("최대 거리가 정상적으로 반환되는지 검증")
    public void 최대_거리_확인_테스트() {
        int maxDistance = cars.getMaxDistance(); // 최대 거리 계산
        assertEquals(2, maxDistance);
    }

    @Test
    @DisplayName("우승자가 복수일 경우 정상적으로 반환되는지 검증")
    public void 복수_우승자_자동차_반환_테스트() {
        int maxDistance = cars.getMaxDistance();
        List<Car> winnerCars = cars.getWinners(maxDistance);

        assertEquals(2, winnerCars.size());
        assertEquals("pobi", winnerCars.get(0).getCarName());
        assertEquals("woni", winnerCars.get(1).getCarName());
    }

    @Test
    @DisplayName("단독 우승자가 정상적으로 반환되는지 검증")
    public void 단독_우승_자동차_반환_테스트() {
        // given: pobi만 추가로 전진하여 단독 우승자로 설정
        Car pobi = cars.getCars().get(0); // pobi 객체 가져오기
        pobi.moveForward(new Movable() {   // pobi를 추가로 한 칸 더 전진시켜 단독 우승자로 설정
            @Override
            public boolean canMove() {
                return true;
            }
        });

        // when: 최대 거리 계산
        int maxDistance = cars.getMaxDistance();
        List<Car> winnerCars = cars.getWinners(maxDistance);

        // then: 단독 우승자 확인
        assertEquals(1, winnerCars.size());
        assertEquals("pobi", winnerCars.get(0).getCarName());
    }
}
