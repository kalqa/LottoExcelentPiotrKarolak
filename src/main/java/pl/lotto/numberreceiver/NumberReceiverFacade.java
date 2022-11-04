package pl.lotto.numberreceiver;

import java.util.List;
import pl.lotto.numberreceiver.dto.NumberReceiverResultDto;

public class NumberReceiverFacade {

    public static final String FAILURE_MESSAGE = "failure";
    public static final String SUCCESS_MESSAGE = "success";
    public final int MAXIMUM_NUMBERS_FROM_USER = 6;

    NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        if (hasUserGaveLessThanSixNumbers(numbersFromUser)) {
            return new NumberReceiverResultDto(FAILURE_MESSAGE);
        }
        return new NumberReceiverResultDto(SUCCESS_MESSAGE);
    }

    private boolean hasUserGaveLessThanSixNumbers(List<Integer> numbersFromUser) {
        return numbersFromUser.size() < MAXIMUM_NUMBERS_FROM_USER;
    }
}
