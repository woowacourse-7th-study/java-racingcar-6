package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    String name;
    Car car;


    @BeforeEach
    void setup() {
        name = "test";
        car = new Car(name);
    }

    @Test
    @DisplayName("자동차의 이름을 받아오는 데 성공한다.")
    void getName() {
        // given
        String expected = name;

        // when
        String real = car.getName();

        // then
        assertThat(real).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차의 현재 위치를 받아오는 데 성공한다.")
    void getPosition() {
        // given
        int expected = 0;

        // when
        int real = car.getPosition();

        // then
        assertThat(real).isEqualTo(expected);
    }

    @Test
    @DisplayName("선택한 수가 3 이하인 경우 정지한다.")
    void moveStop() {
        // given
        int randomNumber = 3;
        int expected = 0;

        // when
        car.move(randomNumber);
        int real = car.getPosition();

        // then
        assertThat(real).isEqualTo(expected);
    }

    @Test
    @DisplayName("선택한 수가 4 이상인 경우 전진한다.")
    void moveForward() {
        // given
        int randomNumber = 4;
        int expected = 1;

        // when
        car.move(randomNumber);
        int real = car.getPosition();

        // then
        assertThat(real).isEqualTo(expected);
    }

}