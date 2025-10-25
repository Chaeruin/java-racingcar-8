package racingcar.controller;

import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGame racingGame;

    GameController(InputView inputView, OutputView outputView, RacingGame gameConfig) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGame = gameConfig;
    }
}
