package pl.lotto.resultchecker;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ResultCheckerRepository  extends MongoRepository<WinningTicket,String> {


    WinningTicket findWinningTicketById(String lotteryId);

    boolean existsWinningTicketByDrawDate(LocalDateTime drawDate);

    WinningTicket findWinningTicketByDrawDate(LocalDateTime drawDate);
}
