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

    boolean isTicketWinning(LotteryTicketDto lotteryTicket, WinningNumbersDto winningNumbersDto) {
        return lotteryTicket.numbers().equals(winningNumbersDto.winningNumbers());
    }
}
