package pl.lotto.numberreceiver;

import java.util.concurrent.atomic.AtomicLong;

class UserLotteryIdGenerator {

    private static AtomicLong userLotteryId = new AtomicLong(0);

    public Long generateUserLotteryId(String message) throws ValidationExeption {
        if (message.equals("success")) {
            userLotteryId.incrementAndGet();
            return Long.valueOf(userLotteryId.get());
        }
        throw new ValidationExeption();
    }


}
