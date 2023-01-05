package pl.lotto.resultchecker;

import pl.lotto.numberreceiver.dto.LotteryTicketDto;

    public interface ResultCheckerRepository {

        LotteryTicketDto save(LotteryTicketDto lotteryTicketDto);

        LotteryTicketDto findTicketbyId(String lotteryid);

    }
