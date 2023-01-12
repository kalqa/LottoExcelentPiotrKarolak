package pl.lotto.numberreceiver.dto;

import java.time.LocalDateTime;
import java.util.List;

public record LotteryTicketDto(List<Integer> numbers, String lotteryId, LocalDateTime DrawDate) {
}
