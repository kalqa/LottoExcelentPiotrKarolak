package pl.lotto.resultchecker;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Builder
public record WinningTicket(String id, List<Integer> numbers, String lotteryId, LocalDateTime drawDate) {
}
