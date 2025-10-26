package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("정상 이름으로 생성하면 이름과 초기 위치가 설정된다")
    void createCarWithValidName() {
        Car car = new Car("pobi");

        assertEquals("pobi", car.getName());
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("moveForward일 때 위치가 1 증가한다")
    void moveBehavior() {
        Car car = new Car("pobi");

        car.moveForward();
        assertEquals(1, car.getPosition());
    }

}