package racingcar.enums;

public enum ErrorCode {
    INPUT_IS_NULL("입력 값이 없습니다."),
    INPUT_IS_NOT_NUMBER("입력 값이 숫자/정수가 아닙니다."),
    INPUT_IS_NOT_IN_RANGE("입력 값이 0 이하입니다."),
    CAR_NAME_IS_NULL("자동차 이름이 빈 값입니다."),
    CAR_NAMES_LENGTH_OVER_FIVE("자동차 이름이 5자 초과입니다."),
    DELIMITER_IS_NOT_APPROPRIATE("구분자(,)가 적절하지 않습니다.");

    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
