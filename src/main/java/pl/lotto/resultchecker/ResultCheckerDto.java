package pl.lotto.resultchecker;

import pl.lotto.numberreceiver.dto.LotteryTicketDto;

import java.time.LocalDateTime;
import java.util.List;

public record ResultCheckerDto(List<Integer> winningNumbers, List<LotteryTicketDto> usersTickets, LocalDateTime drawDate) {
}
