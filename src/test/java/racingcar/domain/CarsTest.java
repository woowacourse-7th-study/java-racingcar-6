package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.FindCarService;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
    }

    @Test
    @DisplayName("자동차 이름 개수만큼 자동차를 생성하는 데 성공한다.")
    void createCars() {
        // given
        String[] names = new String[]{"abc", "def", "ghi"};

        // when
        cars.createCars(names);

        int real = cars.length();
        int expected = names.length;

        // then
        assertThat(real).isEqualTo(expected);
    }

    @Test
    @DisplayName("인덱스를 통해 자동차 정보를 가져오는 데 성공한다.")
    void getByIndex() {
        // given
        String[] names = new String[]{"abc", "def", "ghi"};
        cars.createCars(names);

        // when
        Car findCar = FindCarService.getCar(cars, 1);

        String real = findCar.getName();
        String expected = names[1];

        // then
        assertThat(real).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차 이름을 통해 자동차 정보를 가져오는 데 성공한다.")
    void getByName() {
        // given
        String[] names = new String[]{"abc", "def", "ghi"};
        cars.createCars(names);

        // when
        Car findCar = FindCarService.getCar(cars, "def");

        String real = findCar.getName();
        String expected = names[1];

        // then
        assertThat(real).isEqualTo(expected);
    }

    @Test
    @DisplayName("만들어진 자동차의 개수를 구하는 데 성공한다.")
    void length() {
        // given
        String[] names = new String[]{"abc", "def", "ghi"};
        cars.createCars(names);

        // when
        int real = cars.length();
        int expected = names.length;

        // then
        assertThat(real).isEqualTo(expected);
    }

}