package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public void printStart() {
        System.out.println("실행 결과");
    }

    public void printExecutionOnce(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String result = "최종 우승자 : ";
        for (String winner : winners) {
            result = result.concat( ", " + winner);
        }
        result = result.replaceFirst(", ", "");
        System.out.println(result);
    }
}
