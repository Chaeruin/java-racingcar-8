package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.enums.ErrorCode;

public class InputParser {

    public static List<String> parseCarNames(String input) {
        List<String> carNames = Arrays.stream(input.split(",")).toList();
        return Validator.validateCarNames(carNames);
    }

    public static class Validator {
        public static List<String> validateCarNames(List<String> carNames) {
            if (validateIsNameEmpty(carNames)) {
                throw new IllegalArgumentException(ErrorCode.CAR_NAME_IS_NULL.getErrorMessage());
            }
            if (validateIsNameLengthUnderFive(carNames)) {
                throw new IllegalArgumentException(ErrorCode.CAR_NAMES_LENGTH_OVER_FIVE.getErrorMessage());
            }
            if (validateIsDelimiterComma(carNames)) {
                throw new IllegalArgumentException(ErrorCode.DELIMITER_IS_NOT_APPROPRIATE.getErrorMessage());
            }
            return carNames;
        }

        public static boolean validateIsNameEmpty(List<String> carNames) {
            return carNames.stream()
                    .anyMatch(String::isEmpty);
        }

        public static boolean validateIsNameLengthUnderFive(List<String> carNames) {
            return carNames.stream()
                    .allMatch(carName -> carName.length() <= 5);
        }

        public static boolean validateIsDelimiterComma(List<String> carNames) {
            return carNames.stream()
                    .noneMatch(carName -> carName.startsWith(" ") || carName.endsWith(" "));
        }
    }
}
