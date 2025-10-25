package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.Judgment;
import racingcar.service.RacingGame;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<Car> cars = RacingGame.createCars(InputParser.parseCarNames(inputView.getCarNames()));
        int number = inputView.getNumber();
        // outputView.printStart();
        for (int i = 0; i < number; i++) {
            RacingGame.executeOnce(cars);
            // outputView.printExecutionOnce(cars);
        }
        List<String> winners = Judgment.getWinnersName(Judgment.getWinners(cars));
        // outputView.printWinner(winners);
    }
}
