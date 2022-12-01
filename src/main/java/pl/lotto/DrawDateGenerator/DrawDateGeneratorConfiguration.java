package pl.lotto.DrawDateGenerator;

import java.time.Clock;

public class DrawDateGeneratorConfiguration {

    public DrawDateGeneratorFacade drawDateGeneratorFacadeForTest(Clock clock){
        DateGenerator dateGenerator = new DateGenerator(clock);
        return new DrawDateGeneratorFacade(dateGenerator);
    }

}
