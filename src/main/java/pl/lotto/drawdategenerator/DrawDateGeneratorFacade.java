package pl.lotto.drawdategenerator;

import java.time.LocalDateTime;
import pl.lotto.drawdategenerator.dto.DrawDateDto;


public class DrawDateGeneratorFacade {

    DateGenerator dateGenerator;

    public DrawDateGeneratorFacade(DateGenerator dateGenerator) {
        this.dateGenerator = dateGenerator;
    }


    public DrawDateDto generateNextDrawDate(LocalDateTime ticketCreatedAt) {
        LocalDateTime drawDate = dateGenerator.generateDrawDate(ticketCreatedAt);
        return new DrawDateDto(drawDate);
    }
}
