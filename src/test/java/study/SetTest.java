package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

    /**
     * 요구사항 1
     * - Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
     */
    @Test
    @DisplayName("size 테스트")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    /**
     * 요구사항 2
     * - Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
     * - 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
     * - JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다
     * */
    @Test
    @DisplayName("contains 테스트")
    void contains(){
        assertThat(numbers).contains(1);
        assertThat(numbers).contains(2);
        assertThat(numbers).contains(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains_using_ParameterizedTest(int i){
        assertThat(numbers).contains(i);
    }
}
