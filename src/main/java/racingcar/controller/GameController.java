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
    private final Judgment judgment;
    private final RacingGame racingGame;

    public GameController(InputView inputView, OutputView outputView, Judgment judgment, RacingGame racingGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.judgment = judgment;
        this.racingGame = racingGame;
    }

    public void run() {
        try {
            List<Car> cars = racingGame.createCars(InputParser.parseCarNames(inputView.getCarNames()));
            int number = inputView.getNumber();
            outputView.printStart();
            executeRacing(number, cars);
            List<String> winners = judgment.getWinnersName(judgment.getWinners(cars));
            outputView.printWinners(winners);
        } finally {
            inputView.consoleClose();
        }
    }

    private void executeRacing(int number, List<Car> cars) {
        for (int i = 0; i < number; i++) {
            cars = racingGame.executeOnce(cars);
            outputView.printExecutionOnce(cars);
        }
    }
}
