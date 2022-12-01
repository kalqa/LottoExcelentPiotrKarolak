package pl.lotto.numberreceiver;

import org.junit.jupiter.api.Test;
import pl.lotto.DrawDateGenerator.DrawDateGeneratorConfiguration;
import pl.lotto.DrawDateGenerator.DrawDateGeneratorFacade;

import java.time.*;

public class DrawDateGeneratorFacadeTest {



    @Test
    public void should_return_saturday_at_eight_pm(){
        //given
        LocalDateTime today = LocalDateTime.of(2022, Month.DECEMBER, 1,15,00);
        Clock clock =  Clock.fixed(today.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());

        DrawDateGeneratorFacade drawDateGeneratorFacade = new DrawDateGeneratorConfiguration().drawDateGeneratorFacadeForTest(clock);
        //when

        //then
    }


}
