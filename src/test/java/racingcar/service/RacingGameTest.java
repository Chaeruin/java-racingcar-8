package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;

class RacingGameTest {

    private final NumberGenerator alwaysTrue = () -> 9;
    private final NumberGenerator alwaysFalse = () -> 0;

    @Test
    @DisplayName("createCars가 입력된 이름으로 자동차들을 생성하고 초기 위치는 0이다")
    void createCarsCreatesCarsWithGivenNamesAndZeroPosition() {
        List<String> names = List.of("pobi", "crong", "honux");

        List<Car> cars = RacingGame.createCars(names);

        assertEquals(3, cars.size());
        assertEquals(names, cars.stream().map(Car::getName).toList());
        assertTrue(cars.stream().allMatch(car -> car.getPosition() == 0));
    }

    @Test
    @DisplayName("executeOnce가 각 자동차의 NumberGenerator에 따라 위치를 변경한다")
    void executeOnceMovesCarsAccordingToNumberGenerator() {
        Car pobi = new Car("pobi", alwaysTrue);
        Car crong = new Car("crong", alwaysFalse);

        List<Car> result = RacingGame.executeOnce(List.of(pobi, crong));

        // 참조는 그대로이고 상태(position)가 변경되어야 한다
        assertSame(pobi, result.get(0));
        assertSame(crong, result.get(1));

        assertEquals(1, pobi.getPosition());
        assertEquals(0, crong.getPosition());
    }

    @Test
    @DisplayName("빈 리스트를 입력하면 빈 리스트를 반환한다")
    void executeOnceWithEmptyListReturnsEmpty() {
        List<Car> result = RacingGame.executeOnce(List.of());
        assertTrue(result.isEmpty());
    }
}

