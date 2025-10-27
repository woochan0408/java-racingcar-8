package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void 자동차_생성_성공() {
        // given
        String name = "pobi";

        // when
        Car car = new Car(name);

        // then
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_이름이_5자_초과하면_예외() {
        // given
        String name = "polarbear";

        // when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하");
    }


    @Test
    void 자동차_이름이_빈_문자열이면_예외() {
        // given
        String name = "   ";

        // when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어있을 수 없습니다");
    }

    @Test
    void 자동차_이동_테스트() {
        // given
        Car car = new Car("pobi");
        int initialPosition = car.getPosition();

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(initialPosition);
        assertThat(car.getPosition()).isLessThanOrEqualTo(initialPosition + 1);
    }
}
