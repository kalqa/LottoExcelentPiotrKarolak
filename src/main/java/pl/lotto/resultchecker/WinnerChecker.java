package pl.lotto.resultchecker;

import java.util.List;
import java.util.stream.Collectors;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;
import pl.lotto.numbersgenerator.WinningNumbersDto;

class WinnerChecker {

    List<LotteryTicketDto> checkWinningTickets(AllNumbersFromUsersDto allNumbersFromUsersDto, WinningNumbersDto winningNumber) {
        return allNumbersFromUsersDto.allNumbers()
                .stream()
                .filter(ticket -> ticket.numbers().equals(winningNumber.winningNumbers()))
                .collect(Collectors.toList());
    }


    boolean isTicketWinning(PlayerResult playerResult, WinningNumbersDto winningNumbersDto) {
        return playerResult.winningNumbers().equals(winningNumbersDto.winningNumbers());
    }
}
