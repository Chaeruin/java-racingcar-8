package racingcar.service;

import java.util.List;
import racingcar.domain.Car;

public class RacingGame {

    public List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> executeAll(List<Car> cars, int number) {
        for (int i = 0; i < number; i++) {
            cars = executeOnce(cars);
        }
        return cars;
    }

    private List<Car> executeOnce(List<Car> cars) {
        return cars.stream()
                .map(Car::moveForward)
                .toList();
    }
}
