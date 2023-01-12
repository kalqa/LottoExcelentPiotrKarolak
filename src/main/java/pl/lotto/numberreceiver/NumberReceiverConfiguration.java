package pl.lotto.numberreceiver;

import java.time.Clock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.lotto.drawdategenerator.DrawDateGeneratorFacade;

@Configuration
public class NumberReceiverConfiguration {

    @Bean
    public NumberReceiverFacade numberReceiverFacade(Clock clock, NumberReceiverRepository repository, DrawDateGeneratorFacade drawDateGeneratorFacade) {
        NumberReceiverValidator numberReceiverValidator = new NumberReceiverValidator();
        UserLotteryIdGenerator userLotteryIdGenerator = new UserLotteryIdGenerator();
//        DrawDateGeneratorFacade drawDateGeneratorFacade = new DrawDateGeneratorFacade(new DateGenerator(clock));
        return new NumberReceiverFacade(numberReceiverValidator, userLotteryIdGenerator, repository, drawDateGeneratorFacade, clock);
    }


    public NumberReceiverFacade numberReceiverFacadeForTest(Clock clock, NumberReceiverRepository repository, DrawDateGeneratorFacade drawDateGeneratorFacade) {
        return numberReceiverFacade(clock, repository, drawDateGeneratorFacade);
    }
}
