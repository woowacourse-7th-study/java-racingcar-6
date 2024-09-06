package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
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