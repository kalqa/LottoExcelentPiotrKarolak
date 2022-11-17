package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;

class LotteryTicket {
    private final LocalDateTime ticketSentDate;
    private final String lotteryId;
    private final List<Integer> numbersFromUser;

    public LotteryTicket(LocalDateTime ticketSentDate, String lotteryId, List<Integer> numbersFromUser) {
        this.ticketSentDate = ticketSentDate;
        this.lotteryId = lotteryId;
        this.numbersFromUser = numbersFromUser;
    }

    LocalDateTime getTicketSentDate() {
        return ticketSentDate;
    }

    String getLotteryId() {
        return lotteryId;
    }

    List<Integer> getNumbersFromUser() {
        return numbersFromUser;
    }
}
