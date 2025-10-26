package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RandomNumberGenerator;

public class RacingGame {

    public static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName, new RandomNumberGenerator()))
                .toList();
    }

    public static List<Car> executeOnce(List<Car> cars) {
        return cars.stream()
                .map(Car::moveForward)
                .toList();
    }
}
