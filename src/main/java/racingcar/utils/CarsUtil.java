package racingcar.utils;

import racingcar.domain.Car;
import racingcar.request.RacingCarRequest;
import racingcar.view.RacingCarInputView;
import racingcar.view.RacingCarOutputView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsUtil {
    private static final String NAME_DELIMITER = ",";

    public static List<Car> carNameInput() {
        String userInput = RacingCarInputView.userCarNameInput();
        try {
            return CarsUtil.generateCars(userInput);
        } catch (IllegalArgumentException e) {
            RacingCarOutputView.printErrorMessage(e.getMessage());
            return carNameInput();
        }
    }

    public static List<Car> generateCars(final String userInput) {
        List<String> carNames = separateCarNames(userInput);
        RacingCarRequest.validates(carNames);
        carNames.forEach(RacingCarRequest::validate);
        return carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    private static List<String> separateCarNames(final String userInput) {
        return Arrays.asList(userInput.split(NAME_DELIMITER, -1));
    }
}
