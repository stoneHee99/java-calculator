package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기가 확인되는지")
    @Test
    void testSizeIsCorrect() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set의 contains() 메소드를 활용해 1,2,3의 값이 존재하는지가 확인되는지")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("Set의 contains() 메소드를 활용해서 주어진 값이 존재하지 않는다면 false가 반환되는지")
    @ParameterizedTest
    @CsvSource({"true, 1", "true, 2", "true, 3", "false, 4", "false, 5"})
    void testContainsReturnFalse(boolean expected, int number) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
