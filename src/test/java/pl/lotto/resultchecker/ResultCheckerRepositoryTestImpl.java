package pl.lotto.resultchecker;

import pl.lotto.numberreceiver.dto.LotteryTicketDto;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ResultCheckerRepositoryTestImpl implements ResultCheckerRepository {

    Map<String, LotteryTicketDto> database = new ConcurrentHashMap<>();

    @Override
    public LotteryTicketDto save(LotteryTicketDto lotteryTicketDto) {
        return database.put(lotteryTicketDto.lotteryId(),lotteryTicketDto);
    }

    @Override
    public LotteryTicketDto findTicketById(String lotteryId) {
      List<LotteryTicketDto> lotteryTicketDtoList = database.values()
                .stream()
                .filter(e -> e.lotteryId().equals(lotteryId))
                .collect(Collectors.toList());

      return lotteryTicketDtoList.get(0);

    }
}
