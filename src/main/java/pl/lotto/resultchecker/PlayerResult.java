package pl.lotto.resultchecker;


import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Builder


// lottery ticket
public record PlayerResult(String id, List<Integer> winningNumbers, List<LotteryTicketDto> usersTickets, LocalDateTime drawDate) {
}
