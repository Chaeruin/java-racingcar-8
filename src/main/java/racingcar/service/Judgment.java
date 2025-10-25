package racingcar.service;

import java.util.List;
import racingcar.domain.Car;

public class Judgment {

    public static List<String> getWinnersName(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .toList();
    }

    public static List<Car> getWinners(List<Car> cars) {
        return cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition(cars))
                .toList();
    }

    private static int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
