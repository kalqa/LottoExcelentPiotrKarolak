package pl.lotto.resultchecker;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ResultCheckerRepository  extends MongoRepository<PlayerResult,String> {


    PlayerResult findPlayerResultById(String lotteryId);

    boolean existsPlayerResultByDrawDate(LocalDateTime drawDate);

    PlayerResult findPlayerResultByDrawDate(LocalDateTime drawDate);
}
