package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    /**
     * 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
     * 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
     * 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
     */
    StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("숫자가 하나일 때")
    void oneNumber() {
        assertThat(calculator.calculate("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("빈 값일 때")
    void emptyString() {
        String nullString = null;
        assertThat(calculator.calculate(nullString)).isEqualTo(0);
        assertThat(calculator.calculate("")).isEqualTo(0);
    }

    @Test
    @DisplayName("정상 케이스")
    void normalCase() {
        String request = "2 + 3 * 4 / 2";
        assertThat(calculator.calculate(request)).isEqualTo(10);
    }

    @Test
    @DisplayName("예외 케이스 (비허용문자)")
    void exceptionCase_wrongString() {
        String request = "2 ? 3 * 4 / 2";
        assertThatThrownBy(() -> calculator.calculate(request)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("예외 케이스 (잘못된연산순서)")
    void exceptionCase_wrongOrder() {
        String request = "2 3 * 4 / 2";
        assertThatThrownBy(() -> calculator.calculate(request)).isInstanceOf(IllegalArgumentException.class);
    }

}
