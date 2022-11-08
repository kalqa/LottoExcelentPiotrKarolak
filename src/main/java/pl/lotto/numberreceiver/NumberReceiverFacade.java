package pl.lotto.numberreceiver;

import java.util.List;
import pl.lotto.numberreceiver.dto.NumberReceiverResultDto;

public class NumberReceiverFacade {

    public static final String FAILURE_MESSAGE = "failure";
    public static final String SUCCESS_MESSAGE = "success";
    public final int MAXIMUM_NUMBERS_FROM_USER = 6;

    public final int MAXIMUM_NUMBER = 99;

    public final int MINIMUM_NUMBER = 1;

    NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        if (!hasUserGaveExactlySixNumbers(numbersFromUser) || hasUserGaveDuplicate(numbersFromUser) || !hasUserGaveNumberInRange(numbersFromUser)) {
            return new NumberReceiverResultDto(FAILURE_MESSAGE);
        }



        return new NumberReceiverResultDto(SUCCESS_MESSAGE);
    }

    private boolean hasUserGaveLessThanSixNumbers(List<Integer> numbersFromUser) {
        return numbersFromUser.size() < MAXIMUM_NUMBERS_FROM_USER;
    }

    private boolean hasUserGaveMoreThenSixNumbers(List<Integer> numbersFromUser) {
        return numbersFromUser.size() >MAXIMUM_NUMBERS_FROM_USER;
    }

    private  boolean hasUserGaveExactlySixNumbers(List<Integer> numbersFromUser){
        return numbersFromUser.size() == MAXIMUM_NUMBERS_FROM_USER;
    }

    private boolean hasUserGaveDuplicate(List<Integer> numbersFromUser){
        return numbersFromUser.stream().distinct().count() != MAXIMUM_NUMBERS_FROM_USER;
    }

    private boolean hasUserGaveNumberInRange(List<Integer> numbersFromUser){
        boolean isInRange = true;
        for (Integer integer :
                numbersFromUser) {
            if (integer > MAXIMUM_NUMBER || integer < MINIMUM_NUMBER)
                isInRange = false;

        }
        return isInRange;

    }
}
