package pl.lotto.numberreceiver;

import java.util.UUID;

class UserLotteryIdGenerator {


    private static final String CORRECT_MESSAGE = "success";

    public UUID generateUserLotteryId(String message) {
        return UUID.randomUUID();
    }


    private boolean isCorrect(String message) {
        if (message.equals(CORRECT_MESSAGE)) {
            return true;
        }

        return false;
    }


}
