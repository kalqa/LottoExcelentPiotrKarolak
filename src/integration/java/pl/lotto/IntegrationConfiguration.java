package pl.lotto;


import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.*;

@TestConfiguration
public class IntegrationConfiguration {


    @Bean
    Clock clock() {
        LocalDateTime today = LocalDateTime.of(2023, Month.JANUARY, 19, 11, 0, 0);
        return Clock.fixed(today.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
    }

}
