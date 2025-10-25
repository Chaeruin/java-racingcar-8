package racingcar.service;

import java.util.List;
import racingcar.domain.Car;

public class RacingGame {

    public static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public static List<Car> executeOnce(List<Car> cars) {
        return cars.stream()
                .map(Car::moveForward)
                .toList();
    }
}
