package pl.lotto.numberreceiver;

import java.time.Clock;
import pl.lotto.drawdategenerator.DrawDateGeneratorFacade;

public class NumberReceiverConfiguration {


    public NumberReceiverFacade numberReceiverFacadeForTest(Clock clock, NumberReceiverRepository repository, DrawDateGeneratorFacade drawDateGeneratorFacade) {
        NumberReceiverValidator numberReceiverValidator = new NumberReceiverValidator();
        UserLotteryIdGenerator userLotteryIdGenerator = new UserLotteryIdGenerator();
//        DrawDateGeneratorFacade drawDateGeneratorFacade = new DrawDateGeneratorFacade(new DateGenerator(clock));
        return new NumberReceiverFacade(numberReceiverValidator, userLotteryIdGenerator, repository, drawDateGeneratorFacade, clock);
    }
}
