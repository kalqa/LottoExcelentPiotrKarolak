package pl.lotto.numberreceiver;

import java.util.List;
import pl.lotto.numberreceiver.dto.NumberReceiverResultDto;

public class NumberReceiverFacade {
    NumberReceiverValidator validator;

    NumberReceiverFacade(NumberReceiverValidator validator) {
        this.validator = validator;
    }

    NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        NumberValidationResult validate = validator.validate(numbersFromUser);
        String message = validate.validationMessage();
        return new NumberReceiverResultDto(message);
    }

//    NumbersFromUsersDto fetchAllTicketsForDate(LocalDateTime date) {
//
//    }
}
