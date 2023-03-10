package racingcar.request;

import java.util.HashSet;
import java.util.List;

public class RacingCarRequest {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MINIMUM_COUNT = 1;
    private static final int MAXIMUM_COUNT = 9;
    private static final String NULL_OR_EMPTY_NAME_ERROR_MESSAGE = "이름은 필수 입력 값입니다.";
    private static final String MAX_NAME_LENGTH_ERROR_MESSAGE = "이름을 5글자 이하로 입력해주세요.";
    private static final String DUPLICATE_CAR_NAME_EXIST_ERROR_MESSAGE = "중복된 차 이름이 존재합니다.";
    private static final String INVALID_ROUND_ERROR_MESSAGE = "정수로 입력해 주세요.";
    private static final String MAXIMUM_COUNT_ERROR_MESSAGE = "입력횟수는 9 이하의 정수여야 합니다.";
    private static final String MINIMUM_COUNT_ERROR_MESSAGE = "입력횟수는 1 이상의 정수여야 합니다.";

    public static void validate(final String name){
        if (isNullOrEmptyName(name)){
            throw new IllegalArgumentException(NULL_OR_EMPTY_NAME_ERROR_MESSAGE);
        }
        if (isIllegalLength(name)){
            throw new IllegalArgumentException(MAX_NAME_LENGTH_ERROR_MESSAGE);
        }
    }
    public static void validates(final List<String> names){
        if (isDuplicateNames(names)){
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_EXIST_ERROR_MESSAGE);
        }
    }
    public static void validateNumber(final String countString) {
        try {
            int count = Integer.parseInt(countString);
            checkMinimumCount(count);
            checkMaximumCount(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ROUND_ERROR_MESSAGE);
        }
    }
    private static void checkMaximumCount(int count) {
        if (count >= MAXIMUM_COUNT) {
            throw new IllegalArgumentException(MAXIMUM_COUNT_ERROR_MESSAGE);

        }
    }
    private static void checkMinimumCount(int count) {
        if (count < MINIMUM_COUNT) {
            throw new IllegalArgumentException(MINIMUM_COUNT_ERROR_MESSAGE);
        }
    }
    private static boolean isNullOrEmptyName(final String name) {
        return name == null || name.isBlank();
    }
    private static boolean isDuplicateNames(final List<String> names) {
        return new HashSet<>(names).size() != names.size();
    }
    private static boolean isIllegalLength(final String name) {
        return name.length() > MAX_NAME_LENGTH;
    }
}
