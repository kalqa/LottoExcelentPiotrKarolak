package pl.lotto.numberreceiver;


import java.time.Clock;
import java.time.LocalDateTime;

class LotteryDateGenerator {

    private static final String CORRECT_MESSAGE = "success";

    private final Clock clock;

    LotteryDateGenerator(Clock clock) {
        this.clock = clock;
    }

    public LocalDateTime generateLotteryDate(String message) throws ValidationExeption {
        if (isCorrectMessage(message)) {
            return LocalDateTime.now(clock).minusHours(1);
        }

        throw new ValidationExeption();
    }

    private boolean isCorrectMessage(String message) {
        if (message.equals(CORRECT_MESSAGE)) {
            return true;
        }
        return false;
    }

}
