package racingcar.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarRequestTest {

    @Test
    @DisplayName("자동차의 이름이 5글자 이상일 경우 예외 발생 검증")
    void validateTest() {
        String nameString = "son,leeson";
        assertThatThrownBy(() -> RacingCarRequest.validate(nameString)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("자동차의 이름이 중복일 경우 예외 발생 검증")
    void validatesName() {
        String nameString = "son,son";
        assertThatThrownBy(() -> RacingCarRequest.validate(nameString)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("입력 횟수 값이 1 미만일 경우 예외 발생 검증")
    void validateNumberMin() {
        String countString = "0";
        assertThatThrownBy(() -> RacingCarRequest.validateNumber(countString)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("입력 횟수 값이 9 이상일 경우 예외 발생 검증")
    void validateNumberMax() {
        String countString = "15";
        assertThatThrownBy(() -> RacingCarRequest.validateNumber(countString)).isInstanceOf(RuntimeException.class);
    }
}