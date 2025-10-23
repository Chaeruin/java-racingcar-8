package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Validator.validateCarNames(Console.readLine());
    }

    public String getNumber(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public static class Validator {
        // 자동차 이름 입력 검증
        public static String validateCarNames(String message) {
            return validateBlank(message);
        }

        private static String validateBlank(String message) {
            if (message.isBlank()) {
                throw new IllegalArgumentException();
            }
            return message;
        }
    }
}
