package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RandomNumberGenerator;

public class RacingGame {

    public List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName, new RandomNumberGenerator()))
                .toList();
    }

    public List<Car> executeOnce(List<Car> cars) {
        return cars.stream()
                .map(Car::moveForward)
                .toList();
    }
}
