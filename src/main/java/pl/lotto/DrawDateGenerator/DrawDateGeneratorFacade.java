package pl.lotto.DrawDateGenerator;

import java.time.LocalDateTime;

public class DrawDateGeneratorFacade {

    DateGenerator dateGenerator;

    public DrawDateGeneratorFacade(DateGenerator dateGenerator) {
        this.dateGenerator = dateGenerator;
    }

    public LocalDateTime previousDrawDate(LocalDateTime date) {

        return dateGenerator.previousDrawDate(date);
    }

/*    public LocalDateTime nextDrawDate(LocalDateTime userTicketCreatedTime) {
        dateGenerator.generateDrawDate(userTicketCreatedTime);

    }*/
}