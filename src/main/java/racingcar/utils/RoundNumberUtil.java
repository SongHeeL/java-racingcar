package racingcar.utils;

import racingcar.request.RacingCarRequest;
import racingcar.view.RacingCarInputView;
import racingcar.view.RacingCarOutputView;

public class RoundNumberUtil {
    public static int roundInput() {
        String roundNumberString = String.valueOf(RacingCarInputView.userRoundInput());
        try {
            return toIntWithValidate(roundNumberString);
        } catch (IllegalArgumentException e) {
            RacingCarOutputView.printErrorMessage(e.getMessage());
            return roundInput();
        }
    }

    private static int toIntWithValidate(final String roundNumberString) {
        RacingCarRequest.validateNumber(roundNumberString);
        return Integer.parseInt(roundNumberString);
    }
}
