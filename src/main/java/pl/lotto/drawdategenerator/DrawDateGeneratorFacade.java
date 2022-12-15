package pl.lotto.drawdategenerator;

import pl.lotto.drawdategenerator.dto.DrawDateDto;

import java.time.LocalDateTime;

public class DrawDateGeneratorFacade {

    DateGenerator dateGenerator;

    public DrawDateGeneratorFacade(DateGenerator dateGenerator) {
        this.dateGenerator = dateGenerator;
    }



    public DrawDateDto generateNextDrawDate(LocalDateTime ticketCreatedAt){
       return new DrawDateDto( dateGenerator.generateDrawDate(ticketCreatedAt));
    }
        /*    public LocalDateTime nextDrawDate(LocalDateTime userTicketCreatedTime) {
        dateGenerator.generateDrawDate(userTicketCreatedTime);

    }*/
}
