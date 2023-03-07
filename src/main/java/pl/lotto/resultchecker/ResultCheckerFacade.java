package pl.lotto.resultchecker;

import java.time.LocalDateTime;
import java.util.List;

import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;
import pl.lotto.numbersgenerator.NumbersGeneratorFacade;
import pl.lotto.numbersgenerator.WinningNumbersDto;

public class ResultCheckerFacade {
    private final NumberReceiverFacade numberReceiverFacade;
    private final NumbersGeneratorFacade numbersGeneratorFacade;

    private final WinnerChecker winnerChecker;
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

        List<LotteryTicketDto> lotteryTicketDtos = winnerChecker.checkWinningTickets(allNumbersFromUsersDto, winningNumber);
        PlayerResult playerResul = new PlayerResult()
        return lotteryTicketDtos;
    }

    public boolean isWinner(String lotteryId) {
        PlayerResult playerResult = resultCheckerRepository.findPlayerResultById(lotteryId);
        WinningNumbersDto winningNumber = numbersGeneratorFacade.generateWinningNumbers();
        return winnerChecker.isTicketWinning(playerResult, winningNumber);
    }


    public boolean areGeneratedWinnersByDate(LocalDateTime drawTime){
        return resultCheckerRepository.existsLotteryPlayerResultsByDrawDate(drawTime);
    }
}
