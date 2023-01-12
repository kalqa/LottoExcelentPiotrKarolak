package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberReceiverRepository extends MongoRepository<LotteryTicket, String> {

    List<LotteryTicket> findAllByDrawDate(LocalDateTime nextDrawDate);
}
