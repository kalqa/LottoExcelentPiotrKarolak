package pl.lotto.numberreceiver;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.sun.source.tree.LiteralTree;
import pl.lotto.drawdategenerator.DrawDateGeneratorFacade;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;
import pl.lotto.numberreceiver.dto.NumberReceiverResultDto;

public class NumberReceiverFacade {
    NumberReceiverValidator validator;
    UserLotteryIdGenerator userLotteryIdGenerator;
    NumberReceiverRepository repository;

    Clock clock;
    DrawDateGeneratorFacade drawDateGeneratorFacade;


    NumberReceiverFacade(NumberReceiverValidator validator, UserLotteryIdGenerator userLotteryIdGenerator, NumberReceiverRepository repository,DrawDateGeneratorFacade drawDateGeneratorFacade, Clock clock) {
        this.validator = validator;
        this.userLotteryIdGenerator = userLotteryIdGenerator;
        this.repository = repository;
        this.drawDateGeneratorFacade = drawDateGeneratorFacade;
        this.clock = clock;
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
        LocalDateTime lotteryTicketDrawDate = drawDateGeneratorFacade.generateNextDrawDate(LocalDateTime.now(clock));
        UUID lotteryId = userLotteryIdGenerator.generateUserLotteryId(message);
        LotteryTicket lotteryTicket = new LotteryTicket(lotteryTicketDrawDate, lotteryId.toString(), numbersFromUser);
        repository.save(lotteryTicket);
        return new NumberReceiverResultDto(message, lotteryTicketDrawDate, lotteryId.toString());
    }

    public AllNumbersFromUsersDto usersNumbers(LocalDateTime nextDrawDate) {
         LocalDateTime dateTime = drawDateGeneratorFacade.previousDrawDate(nextDrawDate);
        List<LotteryTicket> all = repository.findAllbyDrawDate(dateTime);
        List<LotteryTicketDto> allDto = all.stream().map(x ->{
           LotteryTicketDto lotteryTicketDto = new LotteryTicketDto(x.getNumbersFromUser(),x.getLotteryId(),x.getDrawDate());

            return lotteryTicketDto;
        }).collect(Collectors.toList());

        return new AllNumbersFromUsersDto(allDto);
    }


//    NumbersFromUsersDto fetchAllTicketsForDate(LocalDateTime date) {
//
//    }
}
