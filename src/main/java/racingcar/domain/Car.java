package racingcar.domain;

import lombok.Getter;
import racingcar.request.RacingCarRequest;

@Getter
public class Car {
    private static final int PROCEED_FlAG_NUMBER = 4;
    private final String name;
    private int position;

    public Car(final String name) {
        RacingCarRequest.validate(name);
        this.name = name;
        this.position = 0;
    }

    public void proceed(final int number) {
        if (number >= PROCEED_FlAG_NUMBER) {
            this.position++;
        }
    }
}
