package pl.lotto.drawdategenerator;

import pl.lotto.drawdategenerator.DateGenerator;
import pl.lotto.drawdategenerator.DrawDateGeneratorFacade;

import java.time.Clock;

public class DrawDateGeneratorConfiguration {

    public DrawDateGeneratorFacade drawDateGeneratorFacadeForTest(Clock clock){
        DateGenerator dateGenerator = new DateGenerator(clock);
        return new DrawDateGeneratorFacade(dateGenerator);
    }

}
