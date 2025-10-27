package racingcar;

import racingcar.controller.GameController;
import racingcar.service.Judgment;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Judgment judgment = new Judgment();
        RacingGame racingGame = new RacingGame();
        GameController gameController = new GameController(inputView, outputView, judgment, racingGame);

        gameController.run();
    }
}
