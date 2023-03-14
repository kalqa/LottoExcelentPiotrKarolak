package pl.lotto.infrastructure.scheduler.resultchecker;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.lotto.drawdategenerator.DrawDateGeneratorFacade;
import pl.lotto.drawdategenerator.dto.DrawDateDto;
import pl.lotto.numbersgenerator.NumbersGeneratorFacade;
import pl.lotto.numbersgenerator.WinningNumbersNotFoundException;
import pl.lotto.resultchecker.ResultCheckerFacade;

import java.time.Clock;
import java.time.LocalDateTime;

@Component
@AllArgsConstructor
@Log4j2
public class ResultCheckerScheduler {

    private final ResultCheckerFacade resultCheckerFacade;
    private final DrawDateGeneratorFacade drawDateGeneratorFacade;
    private final NumbersGeneratorFacade numbersGeneratorFacade;

    private final Clock clock;
    @Scheduled(cron = "*/2 * * * * *")
    public void generatePlayerResults() {
        DrawDateDto drawDateDto = drawDateGeneratorFacade.generateNextDrawDate(LocalDateTime.now(clock));
        LocalDateTime drawDate = drawDateDto.drawDate();
        try {

            numbersGeneratorFacade.retriveWinningNumbersforDate(drawDate);

        } catch (WinningNumbersNotFoundException e) {
            log.error(e.getMessage());
            return;
        }

        resultCheckerFacade.checkWinners(drawDate);
        log.info("success!");
    }
}
