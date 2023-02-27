package pl.lotto.resultchecker;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numbersgenerator.NumbersGeneratorFacade;

@Configuration
public class ResultCheckerConfiguration {


    @Bean
    public ResultCheckerFacade resultCheckerFacade(NumberReceiverFacade numberReceiverFacade, NumbersGeneratorFacade numbersGeneratorFacade, ResultCheckerRepository resultCheckerRepository) {
        WinnerChecker winnerChecker = new WinnerChecker();

        return new ResultCheckerFacade(numberReceiverFacade,numbersGeneratorFacade,winnerChecker,resultCheckerRepository);
    }

}
