package pl.lotto.numbersgenerator;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NumbersGeneratorConfiguration {


    @Bean
    public  NumbersGeneratorFacade numbersGeneratorFacade(){
        WinningNumberGenerator winningNumberGenerator = new WinningNumberGenerator();
        return new NumbersGeneratorFacade(winningNumberGenerator);
    }



}
