package pl.lotto.drawdategenerator;

import java.time.Clock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DrawDateGeneratorConfiguration {

    @Bean
    public DrawDateGeneratorFacade drawDateGeneratorFacade(Clock clock) {
        DateGenerator dateGenerator = new DateGenerator(clock);
        return new DrawDateGeneratorFacade(dateGenerator);
    }

    public DrawDateGeneratorFacade drawDateGeneratorFacadeForTest(Clock clock) {
        DateGenerator dateGenerator = new DateGenerator(clock);
        return new DrawDateGeneratorFacade(dateGenerator);
    }

}
