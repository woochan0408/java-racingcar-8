package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int racingCount;
    private final OutputView outputView;

    public RacingGame(List<Car> cars, int racingCount, OutputView outputView) {
        this.cars = cars;
        this.racingCount = racingCount;
        this.outputView = outputView;
    }

    public void run() {
        playRounds();
        announceWinners();
    }

    private void playRounds() {
        for (int i = 0; i < racingCount; i++) {
            cars.forEach(Car::move);
            outputView.printRaceStatus(cars);
        }
    }

    private void announceWinners() {
        List<Car> winners = findWinners();
        outputView.printWinners(winners);
    }

    private List<Car> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
