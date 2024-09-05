package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car;
    String name = "test";

    @BeforeEach
    void setup() {
        car = new Car(name);
    }

    @Test
    @DisplayName("자동차의 이름을 받아오는 데 성공한다.")
    void getName() {
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차의 현재 위치를 받아오는 데 성공한다.")
    void getPosition() {
        assertThat(car.getPosition()).isEqualTo(0);
    }
}