package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {

    @DisplayName("1,2 를 ,로 split 했을 때 1과 2로 잘 분리되는지")
    @Test
    void testSplitIsWork() {
        final String str = "1,2";
        final String[] strArr = str.split(",");
        assertThat(strArr).contains("1", "2");
    }

    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지")
    @Test
    void testSplitIsWorkWhenStringHasNoMatchedRegex() {
        final String str = "1";
        final String[] strArr = str.split(",");
        assertThat(strArr).containsExactly("1");
    }

    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2가 반환되는지")
    @Test
    void testSubstringIsWork() {
        final String str = "(1,2)";
        final String substringStr = str.substring(1, str.length() - 1);
        assertThat(substringStr).isEqualTo("1,2");
    }

    @DisplayName("abc 값이 주어졌을 때 String의 charAt 메소드를 활용해 특정 위치의 문자가 반환되는지")
    @Test
    void testCharAtIsWork() {
        final String str = "abc";

        assertEquals('a', str.charAt(0));
        assertEquals('b', str.charAt(1));
        assertEquals('c', str.charAt(2));
    }

    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치값을 벗어나면" +
            "StringIndexOutOfBoundsException이 발생하는지")
    @Test
    void testCharAtCatchStringIndexOutOfBoundsException() {
        final String str = "abc";

        assertThrows(StringIndexOutOfBoundsException.class, () -> {
           str.charAt(str.length());
        });
    }
}
