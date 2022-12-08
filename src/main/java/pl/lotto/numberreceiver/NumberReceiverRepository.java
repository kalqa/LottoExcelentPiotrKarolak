package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;

public interface NumberReceiverRepository {
    LotteryTicket save(LotteryTicket lotteryTicket);

    List<LotteryTicket> findAll();

    List<LotteryTicket> findAllbyDrawDate(LocalDateTime nextDrawDate);
}
