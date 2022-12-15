package pl.lotto.numberreceiver;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import pl.lotto.drawdategenerator.DrawDateGeneratorFacade;
import pl.lotto.drawdategenerator.dto.DrawDateDto;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;
import pl.lotto.numberreceiver.dto.NumberReceiverResultDto;

public class NumberReceiverFacade {

    private final NumberReceiverValidator validator;
    private final UserLotteryIdGenerator userLotteryIdGenerator;
    private final NumberReceiverRepository repository;
    private final Clock clock;
    private final DrawDateGeneratorFacade drawDateGeneratorFacade;

    NumberReceiverFacade(NumberReceiverValidator validator, UserLotteryIdGenerator userLotteryIdGenerator, NumberReceiverRepository repository, DrawDateGeneratorFacade drawDateGeneratorFacade, Clock clock) {
        this.validator = validator;
        this.userLotteryIdGenerator = userLotteryIdGenerator;
        this.repository = repository;
        this.drawDateGeneratorFacade = drawDateGeneratorFacade;
        this.clock = clock;
    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        NumberValidationResult validate = validator.validate(numbersFromUser);
        String message = validate.validationMessage();
        if (validate.isFailure()) {
            return new NumberReceiverResultDto(message);
        }
        DrawDateDto lotteryTicketDrawDate = drawDateGeneratorFacade.generateNextDrawDate(LocalDateTime.now(clock));
        UUID lotteryId = userLotteryIdGenerator.generateUserLotteryId(message);
        LotteryTicket lotteryTicket = new LotteryTicket(lotteryTicketDrawDate.drawDate(), lotteryId.toString(), numbersFromUser);
        repository.save(lotteryTicket);
        return new NumberReceiverResultDto(message, lotteryTicketDrawDate.drawDate(), lotteryId.toString());
    }

    public AllNumbersFromUsersDto usersNumbers(LocalDateTime drawDate) {
        List<LotteryTicket> all = repository.findAllbyDrawDate(drawDate);
        List<LotteryTicketDto> allDto = all.stream()
                .map(x -> new LotteryTicketDto(x.getNumbersFromUser(), x.getLotteryId(), x.getDrawDate())).collect(Collectors.toList());
        System.out.println("returned tickets:" + all.size() + "for date: " + drawDate);
        return new AllNumbersFromUsersDto(allDto);
    }
}
