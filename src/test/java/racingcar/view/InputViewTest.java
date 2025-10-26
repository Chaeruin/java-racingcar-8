package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    @DisplayName("유효한 자동차 이름 목록은 예외를 던지지 않는다")
    void validateCarNames_valid() {
        assertDoesNotThrow(() -> InputView.Validator.validateCarNames("pobi,crong,honux"));
    }

    @Test
    @DisplayName("자동차 이름 입력이 null이면 예외 발생")
    void validateCarNames_null() {
        assertThrows(IllegalArgumentException.class, () -> InputView.Validator.validateCarNames(null));
    }

    @Test
    @DisplayName("자동차 이름 입력이 빈 문자열이면 예외 발생")
    void validateCarNames_empty() {
        assertThrows(IllegalArgumentException.class, () -> InputView.Validator.validateCarNames(""));
    }

    @Test
    @DisplayName("유효한 시도 횟수는 예외를 던지지 않는다")
    void validateTryCount_valid() {
        assertDoesNotThrow(() -> InputView.Validator.validateNumber("3"));
    }

    @Test
    @DisplayName("시도 횟수 입력이 null이면 예외 발생")
    void validateTryCount_null() {
        assertThrows(IllegalArgumentException.class, () -> InputView.Validator.validateNumber(null));
    }

    @Test
    @DisplayName("시도 횟수 입력이 빈 문자열이면 예외 발생")
    void validateTryCount_empty() {
        assertThrows(IllegalArgumentException.class, () -> InputView.Validator.validateNumber(""));
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아니면 예외 발생")
    void validateTryCount_notNumber() {
        assertThrows(IllegalArgumentException.class, () -> InputView.Validator.validateNumber("abc"));
    }

    @Test
    @DisplayName("시도 횟수가 0이거나 음수이면 예외 발생")
    void validateTryCount_nonPositive() {
        assertThrows(IllegalArgumentException.class, () -> InputView.Validator.validateNumber("0"));
        assertThrows(IllegalArgumentException.class, () -> InputView.Validator.validateNumber("-1"));
    }
}