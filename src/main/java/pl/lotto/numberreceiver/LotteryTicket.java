package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;

class LotteryTicket {
    private final LocalDateTime drawDate;
    private final String lotteryId;
    private final List<Integer> numbersFromUser;

    public LotteryTicket(LocalDateTime drawDate, String lotteryId, List<Integer> numbersFromUser) {
        this.drawDate = drawDate;
        this.lotteryId = lotteryId;
        this.numbersFromUser = numbersFromUser;
    }

    LocalDateTime getDrawDate() {
        return drawDate;
    }

    String getLotteryId() {
        return lotteryId;
    }

    List<Integer> getNumbersFromUser() {
        return numbersFromUser;
    }
}
