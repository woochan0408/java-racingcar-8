package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarFactoryTest {

    @Test
    void 자동차_생성_성공() {
        // given
        String input = "pobi,woni,jun";

        // when
        List<Car> cars = CarFactory.createCars(input);

        // then
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
    }


    @Test
    void 잘못된_이름이_포함되면_예외() {
        // given
        String input = "pobi,polarbear,jun";

        // when & then
        assertThatThrownBy(() -> CarFactory.createCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하");
    }

    @Test
    void 빈_이름이_포함되면_예외() {
        // given
        String input = "pobi,,jun";

        // when & then
        assertThatThrownBy(() -> CarFactory.createCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어있을 수 없습니다");
    }

    @Test
    void 한_대의_자동차_생성() {
        // given
        String input = "pobi";

        // when
        List<Car> cars = CarFactory.createCars(input);

        // then
        assertThat(cars).hasSize(1);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
    }
}
