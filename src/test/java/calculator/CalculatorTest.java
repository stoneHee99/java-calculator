package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @DisplayName("쉼표로 구분된 숫자들의 합을 잘 반환하는지")
    @Test
    void isCorrectSumReturnWithSeparatedByCommas() {
        assertEquals(3, Calculator.add("1,2"));
    }

    @DisplayName("콜론으로 구분된 숫자들의 합을 잘 반환하는지")
    @Test
    void isCorrectSumReturnWithSeparatedByColon() {
        assertEquals(6, Calculator.add("1:2:3"));
    }

    @DisplayName("쉼표와 콜론으로 구분된 숫자들의 합을 잘 반환하는지")
    @Test
    void isCorrectSumReturnWithSeparatedByCommasAndColon() {
        assertEquals(10, Calculator.add("1,2:3,4"));
    }

    @DisplayName("사용자 정의 구분자로 숫자들의 합을 잘 반환하는지")
    @Test
    void isCorrectSumReturnWithSeparatedByCustomDelimiter() {
        assertEquals(6, Calculator.add("//;\\n1;2;3"));
    }

    @DisplayName("숫자 이외의 값이 포함되었을 때 RuntimeException이 발생하는지")
    @Test
    void testRuntimeExceptionThrownWithNonNumericArguments() {
        assertThrows(RuntimeException.class, () -> Calculator.add("1,2,삼"));
    }

    @DisplayName("음수가 포함되었을 때 RuntimeException이 발생하는지")
    @Test
    void testRuntimeExceptionThrownWithNegativeArguments() {
        assertThrows(RuntimeException.class, () -> Calculator.add("1,-2,3"));
    }
}
