package pl.lotto.numberreceiver;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
}
