package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void 게임_실행_테스트() {
        // given
        List<Car> cars = CarFactory.createCars("pobi,woni");
        OutputView outputView = new OutputView();
        RacingGame game = new RacingGame(cars, 3, outputView);

        // when
        game.run();

        // then
        assertThat(cars.get(0).getPosition()).isGreaterThanOrEqualTo(0);
        assertThat(cars.get(1).getPosition()).isGreaterThanOrEqualTo(0);
    }

    @Test
    void 우승자_한명_찾기() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car1.move(); // position 증가 시도
        car1.move();
        car1.move();
        List<Car> cars = List.of(car1, car2);

        OutputView outputView = new OutputView();
        RacingGame game = new RacingGame(cars, 0, outputView);

        // when
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        game.run();
        System.setOut(System.out);

        // then
        String result = output.toString();
        assertThat(result).contains("최종 우승자");
    }

    @Test
    void 라운드_진행_확인() {
        // given
        List<Car> cars = CarFactory.createCars("pobi,woni,jun");
        OutputView outputView = new OutputView();
        int racingCount = 5;
        RacingGame game = new RacingGame(cars, racingCount, outputView);

        // when
        game.run();

        // then
        // 5라운드 진행 후 모든 차의 위치는 0 이상이어야 함
        for (Car car : cars) {
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
            assertThat(car.getPosition()).isLessThanOrEqualTo(racingCount);
        }
    }
}
