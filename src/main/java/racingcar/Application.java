package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String carNameInput = inputView.readCarNames();
        List<Car> cars = CarFactory.createCars(carNameInput);

        int racingCount = inputView.readRacingCount();

    }
}
