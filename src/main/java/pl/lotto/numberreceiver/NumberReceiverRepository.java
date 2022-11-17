package pl.lotto.numberreceiver;

import java.util.List;

public interface NumberReceiverRepository {
    LotteryTicket save(LotteryTicket lotteryTicket);

    List<LotteryTicket> findAll();
}
