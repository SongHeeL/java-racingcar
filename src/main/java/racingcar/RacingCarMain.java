package racingcar;

import racingcar.Service.RacingService;
import racingcar.domain.Car;
import racingcar.view.RacingCarOutputView;
import racingcar.utils.CarsUtil;
import racingcar.utils.RoundNumberUtil;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        List<Car> cars = CarsUtil.carNameInput();
        int round = RoundNumberUtil.roundInput();
        RacingService racingService = new RacingService(cars);
        racingService.race(round);
        RacingCarOutputView.printWinners(racingService.findWinners());
    }
}
