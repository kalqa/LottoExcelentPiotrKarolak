package pl.lotto.resultannoucer;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.lotto.resultchecker.ResultCheckerFacade;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ResultAnnouncerTest {


    @Test
    public void should_return_success_message() {
        //given
        ResultCheckerFacade resultCheckerFacade = Mockito.mock(ResultCheckerFacade.class);
        ResponseCreator responseCreator = new ResponseCreator();
        ResultAnnouncerFacade resultAnnouncerFacade = new ResultAnnouncerFacade(resultCheckerFacade, responseCreator);
        when(resultCheckerFacade.isWinner("id1")).thenReturn(true);
        //when
        ResultAnnouncerDto result = resultAnnouncerFacade.checkWinner("id1");
        //then
        assertThat(result.message()).isEqualTo("Congrats, you have won!");
    }

    @Test
    public void should_return_failure_message() {
        //given
        ResultCheckerFacade resultCheckerFacade = Mockito.mock(ResultCheckerFacade.class);
        ResponseCreator responseCreator = new ResponseCreator();
        ResultAnnouncerFacade resultAnnoucerFacade = new ResultAnnouncerFacade(resultCheckerFacade, responseCreator);
        when(resultCheckerFacade.isWinner("id1")).thenReturn(false);
        //when
        ResultAnnouncerDto result = resultAnnoucerFacade.checkWinner("id1");
        //then
        assertThat(result.message()).isEqualTo("You have lost");
    }


}
