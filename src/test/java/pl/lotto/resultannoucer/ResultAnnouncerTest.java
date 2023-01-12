package pl.lotto.resultannoucer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.lotto.numbersgenerator.NumbersGeneratorFacade;
import pl.lotto.resultchecker.ResultCheckerFacade;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ResultAnnouncerTest {



    @Test
    public void should_return_succes_message(){
        //given
        ResultCheckerFacade resultCheckerFacade = Mockito.mock(ResultCheckerFacade.class);
        ResponseCreator responseCreator = new ResponseCreator();
        ResultAnnoucerFacade resultAnnoucerFacade = new ResultAnnoucerFacade(resultCheckerFacade,responseCreator);
        LocalDateTime today = LocalDateTime.now();
        when(resultCheckerFacade.IsWinner("id1")).thenReturn(true);
        //when
        ResultAnnoucerDto result = resultAnnoucerFacade.getWinners("id1");
        //then
        assertThat(result.message()).isEqualTo("Congrats, you have won!");
    }

    @Test
    public void should_return_failure_message(){
        //given
        ResultCheckerFacade resultCheckerFacade = Mockito.mock(ResultCheckerFacade.class);
        ResponseCreator responseCreator = new ResponseCreator();
        ResultAnnoucerFacade resultAnnoucerFacade = new ResultAnnoucerFacade(resultCheckerFacade,responseCreator);
        LocalDateTime today = LocalDateTime.now();
        when(resultCheckerFacade.IsWinner("id1")).thenReturn(false);
        //when
        ResultAnnoucerDto result = resultAnnoucerFacade.getWinners("id1");
        //then
        assertThat(result.message()).isEqualTo("You have lost");
    }


}
