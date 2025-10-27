package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        //사용자 입력 및 파싱
        String carNameInput = inputView.readCarNames();
        List<Car> cars = CarFactory.createCars(carNameInput);
        int racingCount = inputView.readRacingCount();

        //게임시작
        RacingGame game = new RacingGame(cars, racingCount, outputView);
        game.run();
    }
}
