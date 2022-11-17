package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;
import pl.lotto.numberreceiver.dto.NumberReceiverResultDto;

public class NumberReceiverFacade {
    NumberReceiverValidator validator;
    UserLotteryIdGenerator userLotteryIdGenerator;
    LotteryDateGenerator lotteryDateGenerator;
    NumberReceiverRepository repository;
//    DrawDateGeneratorFacade drawDateGeneratorFacade;


    NumberReceiverFacade(NumberReceiverValidator validator, UserLotteryIdGenerator userLotteryIdGenerator, LotteryDateGenerator lotteryDateGenerator, NumberReceiverRepository repository) {
        this.validator = validator;
        this.userLotteryIdGenerator = userLotteryIdGenerator;
        this.lotteryDateGenerator = lotteryDateGenerator;
        this.repository = repository;
    }

    public NumberReceiverFacade(NumberReceiverValidator validator) {
        this.validator = validator;
    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        NumberValidationResult validate = validator.validate(numbersFromUser);
        String message = validate.validationMessage();
        if (validate.isFailure()) {
            return new NumberReceiverResultDto(message);
        }
        LocalDateTime ticketSentDate = null;
        UUID lotteryId = userLotteryIdGenerator.generateUserLotteryId(message);
        try {
            ticketSentDate = lotteryDateGenerator.generateLotteryDate(message);
        } catch (ValidationExeption e) {
            new NumberReceiverResultDto(message);
        }
        LotteryTicket lotteryTicket = new LotteryTicket(ticketSentDate, lotteryId.toString(), numbersFromUser);
        repository.save(lotteryTicket);
        return new NumberReceiverResultDto(message, ticketSentDate, lotteryId.toString());
    }

    public AllNumbersFromUsersDto usersNumbers(LocalDateTime nextDrawDate) {
//        drawDateGeneratorFacade.previousDrawDate();
        List<LotteryTicket> all = repository.findAll();
        return new AllNumbersFromUsersDto(
                List.of(
                        new LotteryTicketDto(all.get(0).getNumbersFromUser(), all.get(0).getLotteryId())
                )
        );
//        return new AllNumbersFromUsersDto(
//                List.of(
//                        new LotteryTicketDto(List.of(1, 2, 3, 4, 5, 6), UUID.randomUUID().toString())
//                )
//        );
    }


//    NumbersFromUsersDto fetchAllTicketsForDate(LocalDateTime date) {
//
//    }
}
