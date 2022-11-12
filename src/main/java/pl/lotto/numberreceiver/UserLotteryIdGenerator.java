package pl.lotto.numberreceiver;

import java.util.concurrent.atomic.AtomicLong;

class UserLotteryIdGenerator {

    private static AtomicLong userLotteryId = new AtomicLong(0);

    public Long generateUserLotteryId(String message) {
        if (message.length() == 0) {
            userLotteryId.incrementAndGet();
            return userLotteryId.get();
        }
       return null;
    }


}
