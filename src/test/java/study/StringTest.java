package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    /**
     * 요구사항 1
     * - "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     * - "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     */
    @Test
    @DisplayName("split 테스트 (2개 이상 문자)")
    void split_contains() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");
    }

    @Test
    @DisplayName("split 테스트 (1개 문자)")
    void split_containsExactly() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    /**
     * 요구사항 2
     * - "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
     */
    @Test
    @DisplayName("substring 테스트")
    void substring() {
        String str = "(1,2)";
        String actual = str.substring(1, str.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    /**
     * 요구사항 3
     * - "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
     * - String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
     *      StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
     * - JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     */
    @Test
    @DisplayName("charAt 테스트")
    void charAt(){
        assertThat("abc".charAt(0)).isEqualTo('a');
        assertThat("abc".charAt(1)).isEqualTo('b');
        assertThat("abc".charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt 예외 테스트 (IndexOutOfBounds)")
    void stringIndexOutOfBoundsException(){
        assertThatThrownBy(() -> "abc".charAt(4)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
