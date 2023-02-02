package pl.lotto.infrastructure.scheduler.numbersgenerator;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.lotto.numbersgenerator.NumbersGeneratorFacade;

@Component
@AllArgsConstructor
public class WinningNumbersScheduler {


    private final NumbersGeneratorFacade numbersGeneratorFacade;

    @Scheduled(cron = "*/40 * * * * *")

    public void generateWinningNumbers(){
         numbersGeneratorFacade.generateWinningNumbers();
    }

}
