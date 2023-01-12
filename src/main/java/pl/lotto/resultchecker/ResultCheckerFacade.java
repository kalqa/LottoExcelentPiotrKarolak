package pl.lotto.resultchecker;

import java.time.LocalDateTime;
import java.util.List;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;
import pl.lotto.numbersgenerator.NumbersGeneratorFacade;
import pl.lotto.numbersgenerator.WinningNumbersDto;

public class ResultCheckerFacade {
    private NumberReceiverFacade numberReceiverFacade;
    private NumbersGeneratorFacade numbersGeneratorFacade;

    private WinnerChecker winnerChecker;
    private final ResultCheckerRepository resultCheckerRepository;

    public ResultCheckerFacade(NumberReceiverFacade numberReceiverFacade, NumbersGeneratorFacade numbersGeneratorFacade, WinnerChecker winnerChecker, ResultCheckerRepository resultCheckerRepository) {
        this.numberReceiverFacade = numberReceiverFacade;
        this.numbersGeneratorFacade = numbersGeneratorFacade;
        this.winnerChecker = winnerChecker;
        this.resultCheckerRepository = resultCheckerRepository;
    }

    public List<LotteryTicketDto> checkWinners(LocalDateTime drawTime) {
        AllNumbersFromUsersDto allNumbersFromUsersDto = numberReceiverFacade.usersNumbers(drawTime);
        WinningNumbersDto winningNumber = numbersGeneratorFacade.generateWinningNumbers();
        return winnerChecker.checkWinningTickets(allNumbersFromUsersDto, winningNumber);
    }

    public boolean isWinner(String lotteryId) {
        LotteryTicketDto lotteryTicket = resultCheckerRepository.findTicketById(lotteryId);
        WinningNumbersDto winningNumber = numbersGeneratorFacade.generateWinningNumbers();
        return winnerChecker.isTicketWinning(lotteryTicket, winningNumber);
    }
}
