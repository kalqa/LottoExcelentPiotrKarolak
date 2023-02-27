package pl.lotto;


import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.time.*;

@TestConfiguration
@Profile("integration")
public class IntegrationConfiguration {


    @Bean
    @Primary
    Clock clock() {
        LocalDateTime today = LocalDateTime.of(2023, Month.JANUARY, 19, 11, 0, 0);
        return Clock.fixed(today.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
    }

}
