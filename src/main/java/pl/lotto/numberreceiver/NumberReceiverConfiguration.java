package pl.lotto.numberreceiver;

import java.time.Clock;

@Configuration
public class NumberReceiverConfiguration {

    @Bean
    Clock clock(){
        return Clock.systemUTC();
    }

    @Bean
    public NumberReceiverFacade numberReceiverFacade(Clock clock, NumberReceiverRepository repository) {
        NumberReceiverValidator numberReceiverValidator = new NumberReceiverValidator();
        LotteryDateGenerator lotteryDateGenerator = new LotteryDateGenerator(clock);
        UserLotteryIdGenerator userLotteryIdGenerator = new UserLotteryIdGenerator();
        return new NumberReceiverFacade(numberReceiverValidator, userLotteryIdGenerator, lotteryDateGenerator, repository);
    }

    public NumberReceiverFacade numberReceiverFacadeForTest(Clock clock, NumberReceiverRepository repository) {
        NumberReceiverValidator numberReceiverValidator = new NumberReceiverValidator();
        LotteryDateGenerator lotteryDateGenerator = new LotteryDateGenerator(clock);
        UserLotteryIdGenerator userLotteryIdGenerator = new UserLotteryIdGenerator();
        return new NumberReceiverFacade(numberReceiverValidator, userLotteryIdGenerator, lotteryDateGenerator, repository);
    }
}
