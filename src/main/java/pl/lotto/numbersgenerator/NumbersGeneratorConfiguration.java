package pl.lotto.numbersgenerator;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.lotto.drawdategenerator.DrawDateGeneratorFacade;

@Configuration
public class NumbersGeneratorConfiguration {


    @Bean
    public  NumbersGeneratorFacade numbersGeneratorFacade(WinningNumberRepository winningNumberRepository, DrawDateGeneratorFacade drawDateGeneratorFacade){
        WinningNumberGenerator winningNumberGenerator = new WinningNumberGenerator();

        return new NumbersGeneratorFacade(winningNumberGenerator,winningNumberRepository,drawDateGeneratorFacade);
    }

   public NumbersGeneratorFacade numbersGeneratorFacadeForTest(WinningNumberRepository winningNumberRepository, DrawDateGeneratorFacade drawDateGeneratorFacade){
        WinningNumberGenerator winningNumberGenerator = new WinningNumberGenerator();
        return  new NumbersGeneratorFacade(winningNumberGenerator,winningNumberRepository,drawDateGeneratorFacade);
    }



}
