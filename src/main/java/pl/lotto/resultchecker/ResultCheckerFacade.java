package pl.lotto.resultchecker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pl.lotto.numberreceiver.dto.LotteryTicketDto;
import pl.lotto.numbersgenerator.NumbersGeneratorFacade;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;
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
        List<LotteryTicketDto> winningTickets = winnerChecker.checkWinningTickets(allNumbersFromUsersDto, winningNumber);
        return winningTickets;


    }

    public boolean IsWinner(String lotteryID) {
        LotteryTicketDto lotteryTicket = resultCheckerRepository.findTicketbyId(lotteryID);
        WinningNumbersDto winningNumber = numbersGeneratorFacade.generateWinningNumbers();
        return winnerChecker.isTicketWinning(lotteryTicket,winningNumber);
    }


}
