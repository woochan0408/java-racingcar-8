package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            String position = "-".repeat(car.getPosition());
            System.out.println(car.getName() + " : " + position);
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
