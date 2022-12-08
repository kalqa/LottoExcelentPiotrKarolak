package pl.lotto.numberreceiver;

import pl.lotto.drawdategenerator.DateGenerator;
import pl.lotto.drawdategenerator.DrawDateGeneratorFacade;

import java.time.Clock;

public class NumberReceiverConfiguration {

    public NumberReceiverFacade numberReceiverFacadeForTest(Clock clock, NumberReceiverRepository repository) {
        NumberReceiverValidator numberReceiverValidator = new NumberReceiverValidator();
        LotteryDateGenerator lotteryDateGenerator = new LotteryDateGenerator(clock);
        UserLotteryIdGenerator userLotteryIdGenerator = new UserLotteryIdGenerator();
        DrawDateGeneratorFacade drawDateGeneratorFacade = new DrawDateGeneratorFacade(new DateGenerator(clock));
        return new NumberReceiverFacade(numberReceiverValidator, userLotteryIdGenerator, lotteryDateGenerator, repository,drawDateGeneratorFacade);
    }
}
