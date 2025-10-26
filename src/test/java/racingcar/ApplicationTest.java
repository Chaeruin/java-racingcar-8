package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 입력 예외_빈 값")
    void test1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수 예외_범위 예외")
    void test2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun", "9000000000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수 예외_범위 예외(양수 아님)")
    void test3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수 예외_문자 입력")
    void test4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 파싱 예외_빈 이름1")
    void test5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,jun", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 파싱 예외_빈 이름2")
    void test6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi,jun", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 파싱 예외_이름 길이 5자 초과")
    void test7() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun,abcdef", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 파싱 예외_파싱 실패(구분자 오류)")
    void test8() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,jun.abcd", "5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
