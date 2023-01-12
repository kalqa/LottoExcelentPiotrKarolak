package pl.lotto.numberreceiver;

import java.util.LinkedList;
import java.util.List;
import static java.util.stream.Collectors.joining;
import static pl.lotto.numberreceiver.NumberValidationResult.failure;
import static pl.lotto.numberreceiver.NumberValidationResult.success;
import static pl.lotto.numberreceiver.ValidationError.DUPLICATED_NUMBERS;
import static pl.lotto.numberreceiver.ValidationError.NOT_SIX_NUMBERS;
import static pl.lotto.numberreceiver.ValidationError.OUT_OF_RANGE;

class NumberReceiverValidator {

    public final String ERROR_DELIMETER = ",";
    public final int MAXIMUM_NUMBERS_FROM_USER = 6;

    public final int MAXIMUM_NUMBER = 99;

    public final int MINIMUM_NUMBER = 1;


    List<ValidationError> errors = new LinkedList<>();

    public NumberValidationResult validate(List<Integer> numbersFromUser) {
        if (!hasUserGaveExactlySixNumbers(numbersFromUser)) {
            errors.add(NOT_SIX_NUMBERS);
        }
        if (hasUserGaveDuplicate(numbersFromUser)) {
            errors.add(DUPLICATED_NUMBERS);
        }
        if (!hasUserGaveNumberInRange(numbersFromUser)) {
            errors.add(OUT_OF_RANGE);
        }
        if (errors.isEmpty()) {
            return success();
        }
        String message = concatenateValidationMessage();
        return failure(message);
    }

    private String concatenateValidationMessage() {
        return errors.stream()
                .map(error -> error.message)
                .collect(joining(ERROR_DELIMETER));
    }

    private boolean hasUserGaveExactlySixNumbers(List<Integer> numbersFromUser) {
        return numbersFromUser.size() == MAXIMUM_NUMBERS_FROM_USER;
    }

    private boolean hasUserGaveDuplicate(List<Integer> numbersFromUser) {
        return numbersFromUser.stream()
                .distinct()
                .count() != MAXIMUM_NUMBERS_FROM_USER;
    }

    private boolean hasUserGaveNumberInRange(List<Integer> numbersFromUser) {
        return numbersFromUser
                .stream()
                .noneMatch(this::isInRange);
    }

    private boolean isInRange(Integer integer) {
        return integer > MAXIMUM_NUMBER || integer < MINIMUM_NUMBER;
    }
}
