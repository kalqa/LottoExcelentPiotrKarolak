package pl.lotto.resultchecker;


import org.springframework.data.mongodb.core.mapping.Document;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;

import java.time.LocalDateTime;
import java.util.List;

@Document
public record PlayerResult(String id, List<Integer> winningNumbers, List<LotteryTicketDto> usersTickets, LocalDateTime drawDate) {
}
