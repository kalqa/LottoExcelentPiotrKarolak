package pl.lotto.DrawDateGenerator;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class DrawDateGeneratorFacade {

    DateGenerator dateGenerator;

    public DrawDateGeneratorFacade(DateGenerator dateGenerator) {
        this.dateGenerator = dateGenerator;
    }

/*    public LocalDateTime nextDrawDate(LocalDateTime userTicketCreatedTime) {
        dateGenerator.generateDrawDate(userTicketCreatedTime);

    }*/
}
