package pl.lotto.numberreceiver;

import java.util.UUID;

class UserLotteryIdGenerator {

//    private static AtomicLong userLotteryId = new AtomicLong(0);
    private static final String CORRECT_MESSAGE = "success";

    public UUID generateUserLotteryId(String message) {
//        if (isCorrect(message)) {
//            userLotteryId.incrementAndGet();
//            return Long.valueOf(userLotteryId.get());
//        }
//        throw new ValidationExeption();

//        throw new RuntimeException();
        return UUID.randomUUID();
    }


    private boolean isCorrect(String message) {
        if (message.equals(CORRECT_MESSAGE)) {
            return true;
        }

        return false;
    }


}
