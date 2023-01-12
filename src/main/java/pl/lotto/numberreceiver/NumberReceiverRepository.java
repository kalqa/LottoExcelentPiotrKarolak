package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NumberReceiverRepository extends MongoRepository<LotteryTicket, String> {

    List<LotteryTicket> findAllByDrawDate(LocalDateTime nextDrawDate);
}
