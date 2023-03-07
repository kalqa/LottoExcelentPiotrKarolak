package pl.lotto.resultannoucer;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.lotto.resultchecker.ResultCheckerFacade;

@Configuration
public class ResultAnnoucerConfiguration {


    @Bean
    public ResultAnnouncerFacade resultAnnouncerFacade(ResultCheckerFacade resultCheckerFacade){
        ResponseCreator responseCreator = new ResponseCreator();
        return new ResultAnnouncerFacade(resultCheckerFacade,responseCreator);
    }


}
