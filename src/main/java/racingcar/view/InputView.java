package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.enums.ErrorCode;

public class InputView {

    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Validator.validateCarNames(Console.readLine());
    }

    public int getNumber(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Validator.validateNumber(Console.readLine());
    }

    public static class Validator {
        // 자동차 이름 입력 검증
        public static String validateCarNames(String message) {
            return validateBlank(message);
        }

        private static String validateBlank(String message) {
            if (message.isBlank()) {
                throw new IllegalArgumentException(ErrorCode.INPUT_IS_NULL.getErrorMessage());
            }
            return message;
        }

        // 시도 횟수 입력 검증
        public static int validateNumber(String number) {
            return validateIsInRange(validateIsInt(number));
        }

        public static int validateIsInRange(int number) {
            if (number <= 0) {
                throw new IllegalArgumentException(ErrorCode.INPUT_IS_NOT_IN_RANGE.getErrorMessage());
            }
            return number;
        }

        public static int validateIsInt(String number) {
            try {
                return Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorCode.INPUT_IS_NOT_NUMBER.getErrorMessage());
            }
        }
    }
}
