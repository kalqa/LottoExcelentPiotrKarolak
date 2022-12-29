package pl.lotto.resultchecker;

import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;
import pl.lotto.numbersgenerator.WinningNumbersDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class WinnerChecker {


    List<LotteryTicketDto> checkWinningTickets(AllNumbersFromUsersDto allNumbersFromUsersDto, WinningNumbersDto winningNumber) {

        List<LotteryTicketDto> ticketList = allNumbersFromUsersDto.allNumbers().stream().toList();
        List<LotteryTicketDto> winningTickets =  ticketList.stream().filter(ticket -> ticket.numbers().equals(winningNumber.winningNumbers())).collect(Collectors.toList());

        return winningTickets;

    }
}
