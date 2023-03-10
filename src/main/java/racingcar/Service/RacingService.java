package racingcar.Service;

import racingcar.domain.Car;
import racingcar.view.RacingCarOutputView;
import java.util.*;
import java.util.stream.Collectors;

public class RacingService {
    private static final String INVALID_GET_WINNERS_ERROR_MESSAGE = "에러가 발생했습니다.";
    private final int START_RANDOM_NUMBER = 0;
    private final int END_RANDOM_NUMBER = 9;
    private final List<Car> cars;

    public RacingService(final List<Car> cars) {
        this.cars = cars;
    }

    public void race(final int round) {
        for (int i = 0; i < round; i++) {
            raceRound();
        }
    }

    public List<Car> findWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == findMaxPosition())
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException(INVALID_GET_WINNERS_ERROR_MESSAGE));
    }

    private void raceRound() {
        cars.forEach((car) -> car.proceed((int) ((Math.random() * (END_RANDOM_NUMBER - START_RANDOM_NUMBER)) + START_RANDOM_NUMBER)));

        RacingCarOutputView.printRoundResult(cars);
    }
}
