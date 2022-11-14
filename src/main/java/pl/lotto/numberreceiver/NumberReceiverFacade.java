package pl.lotto.numberreceiver;

import pl.lotto.numberreceiver.dto.NumberReceiverResultDto;

import java.time.LocalDateTime;
import java.util.List;

public class NumberReceiverFacade {
    NumberReceiverValidator validator;
    UserLotteryIdGenerator userLotteryIdGenerator;
    LotteryDateGenerator lotteryDateGenerator;

    public NumberReceiverFacade(NumberReceiverValidator validator, UserLotteryIdGenerator userLotteryIdGenerator, LotteryDateGenerator lotteryDateGenerator) {
        this.validator = validator;
        this.userLotteryIdGenerator = userLotteryIdGenerator;
        this.lotteryDateGenerator = lotteryDateGenerator;
    }
    public NumberReceiverFacade(NumberReceiverValidator validator){
        this.validator = validator;
    }


    NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        NumberValidationResult validate = validator.validate(numbersFromUser);
        String message = validate.validationMessage();

            LocalDateTime lotteryIdGenarated = null;
            Long lotteryId = null;

        try {
            lotteryId = userLotteryIdGenerator.generateUserLotteryId(message);
            lotteryIdGenarated = lotteryDateGenerator.GenerateLotteryDate(message);
        } catch (ValidationExeption e) {
            new NumberReceiverResultDto(message);
        }

        return new NumberReceiverResultDto(message,lotteryIdGenarated,lotteryId);
    }

//    NumbersFromUsersDto fetchAllTicketsForDate(LocalDateTime date) {
//
//    }
}
