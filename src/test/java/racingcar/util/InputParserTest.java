package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    @DisplayName("유효한 자동차 이름 목록은 예외를 던지지 않는다")
    void validateCarNames_valid() {
        List<String> carNames = Arrays.asList("pobi", "crong", "honux");
        assertDoesNotThrow(() -> InputParser.Validator.validateCarNames(carNames));
    }

    @Test
    @DisplayName("자동차 이름 입력이 null이면 예외 발생")
    void validateCarNames_null() {
        assertThrows(IllegalArgumentException.class, () -> InputParser.Validator.validateCarNames(null));
    }

    @Test
    @DisplayName("자동차 이름 입력이 빈 문자열이면 예외 발생")
    void validateCarNames_empty() {
        List<String> carNames = Arrays.asList("");
        assertThrows(IllegalArgumentException.class, () -> InputParser.Validator.validateCarNames(carNames));
    }

    @Test
    @DisplayName("자동차 이름 중 하나가 길이 제한(5자)을 초과하면 예외 발생")
    void validateCarNames_nameTooLong() {
        List<String> carNames = Arrays.asList("pobi", "crong", "abcdef");
        assertThrows(IllegalArgumentException.class, () -> InputParser.Validator.validateCarNames(carNames));
    }
}