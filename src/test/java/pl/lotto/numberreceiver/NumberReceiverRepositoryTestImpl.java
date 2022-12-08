package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class NumberReceiverRepositoryTestImpl implements NumberReceiverRepository {

    Map<String, LotteryTicket> database = new ConcurrentHashMap<>();

    @Override
    public LotteryTicket save(LotteryTicket lotteryTicket) {
        return database.put(lotteryTicket.getLotteryId(), lotteryTicket);
    }

    @Override
    public List<LotteryTicket> findAll() {
        return database.values().stream().toList();
    }

    @Override
    public List<LotteryTicket> findAllbyDrawDate(LocalDateTime nextDrawDate) {
        return database.values().stream().filter(e->e.getDrawDate().equals(nextDrawDate)).collect(Collectors.toList());
    }
}
