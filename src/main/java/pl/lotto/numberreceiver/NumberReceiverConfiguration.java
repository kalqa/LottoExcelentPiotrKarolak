package pl.lotto.numberreceiver;

import java.time.Clock;

public class NumberReceiverConfiguration {

    public NumberReceiverFacade numberReceiverFacadeForTest(Clock clock, NumberReceiverRepository repository) {
        NumberReceiverValidator numberReceiverValidator = new NumberReceiverValidator();
        LotteryDateGenerator lotteryDateGenerator = new LotteryDateGenerator(clock);
        UserLotteryIdGenerator userLotteryIdGenerator = new UserLotteryIdGenerator();
        return new NumberReceiverFacade(numberReceiverValidator, userLotteryIdGenerator, lotteryDateGenerator, repository);
    }
}
