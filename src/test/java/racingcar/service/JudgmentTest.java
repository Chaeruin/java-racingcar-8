package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;

class JudgmentTest {

    private final NumberGenerator alwaysTrue = () -> 9;
    private final NumberGenerator alwaysFalse = () -> 0;
    private final Judgment judgment = new Judgment();

    @Test
    @DisplayName("단일 우승자 반환 (move로 위치 변경하여 최고 위치 결정)")
    void singleWinner() {

        Car pobi = new Car("pobi", alwaysTrue);
        Car crong = new Car("crong", alwaysTrue);
        Car honux = new Car("honux", alwaysFalse);

        pobi.moveForward();
        pobi.moveForward();
        crong.moveForward();

        List<Car> winners = judgment.getWinners(List.of(pobi, crong, honux));

        assertEquals(1, winners.size());
        assertEquals("pobi", winners.get(0).getName());
        assertEquals(2, winners.get(0).getPosition());
    }

    @Test
    @DisplayName("동률인 다수의 우승자 반환 및 원본 순서 유지")
    void multipleWinnersTiePreservesOrder() {
        Car pobi = new Car("pobi", alwaysTrue);
        Car crong = new Car("crong", alwaysTrue);
        Car honux = new Car("honux", alwaysTrue);

        pobi.moveForward();
        pobi.moveForward();
        crong.moveForward();
        crong.moveForward();
        honux.moveForward();

        List<Car> winners = judgment.getWinners(List.of(pobi, crong, honux));
        List<String> winnerNames = judgment.getWinnersName(winners);

        assertEquals(2, winners.size());
        assertEquals(List.of("pobi", "crong"), winnerNames);
    }

    @Test
    @DisplayName("모든 자동차가 같은 위치이면 모두 우승자")
    void allSamePositionAreWinners() {
        Car pobi = new Car("pobi", alwaysTrue);
        Car crong = new Car("crong", alwaysTrue);
        Car honux = new Car("honux", alwaysTrue);

        pobi.moveForward();
        crong.moveForward();
        honux.moveForward();

        List<Car> winners = judgment.getWinners(List.of(pobi, crong, honux));
        List<String> names = judgment.getWinnersName(winners);

        assertEquals(3, winners.size());
        assertEquals(List.of("pobi", "crong", "honux"), names);
    }

    @Test
    @DisplayName("빈 리스트 입력 시 빈 리스트 반환")
    void emptyInputReturnsEmpty() {
        List<Car> winners = judgment.getWinners(List.of());
        List<String> names = judgment.getWinnersName(List.of());

        assertTrue(winners.isEmpty());
        assertTrue(names.isEmpty());
    }
}