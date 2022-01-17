package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseballTest {

    Baseball baseball;

    @BeforeEach
    public void setUp() {
        baseball = new Baseball();
    }

    @Test
    public void checkValidationNumber(){
        assertThat(baseball.checkValidationUserData("abc")).isFalse();
        assertThat(baseball.checkValidationUserData("12345")).isFalse();
        assertThat(baseball.checkValidationUserData("012")).isFalse();
    }

    @Test
    public void testCreateInitData() {
        // 세 자리 숫자가 잘 생성되어야 함
        String initData = baseball.createInitData();
        assertThat(initData).isNotEmpty();
        assertThat(initData.length()).isEqualTo(3);
        assertThat(StringUtils.isNumeric(initData)).isTrue();
        assertThat(
            initData.charAt(0) != initData.charAt(1) && initData.charAt(1) != initData.charAt(2)
                && initData.charAt(0) != initData.charAt(2)).isTrue();
    }

    @Test
    public void testCountStrike() {
        // 두 숫자를 넘겨줬을 때 strike 를 판별해줄 수 있어야 함
        assertThat(baseball.countStrike("123", "145")).isEqualTo(1);
        assertThat(baseball.countStrike("123", "125")).isEqualTo(2);
        assertThat(baseball.countStrike("123", "123")).isEqualTo(3);
    }

    @Test
    public void testCountBall() {
        // 두 숫자를 넘겨줬을 때 ball 를 판별해줄 수 있어야 함
        assertThat(baseball.countBall("123", "451")).isEqualTo(1);
        assertThat(baseball.countBall("123", "512")).isEqualTo(2);
        assertThat(baseball.countBall("123", "123")).isEqualTo(0);
    }

}
