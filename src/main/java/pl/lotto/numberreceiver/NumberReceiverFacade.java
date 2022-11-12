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

            LocalDateTime lotteryIdGenarated = lotteryDateGenerator.GenerateLotteryDate(message);
            long lotteryId = userLotteryIdGenerator.generateUserLotteryId(message);

        return new NumberReceiverResultDto(message);
    }

//    NumbersFromUsersDto fetchAllTicketsForDate(LocalDateTime date) {
//
//    }
}
