package pl.lotto.numberreceiver;

import java.util.concurrent.atomic.AtomicLong;

class UserLotteryIdGenerator {

    private static AtomicLong userLotteryId = new AtomicLong(0);
    private static final String CORRECT_MESSAGE = "success";

    public Long generateUserLotteryId(String message) throws ValidationExeption {
        if (isCorrect(message)) {
            userLotteryId.incrementAndGet();
            return Long.valueOf(userLotteryId.get());
        }
        throw new ValidationExeption();
    }


    private boolean isCorrect(String message) {
        if (message.equals(CORRECT_MESSAGE)) {
            return true;
        }

        return false;
    }


}
