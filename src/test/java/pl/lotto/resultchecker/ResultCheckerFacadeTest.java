package pl.lotto.resultchecker;

import java.util.List;
import org.junit.jupiter.api.Test;
import pl.lotto.numberreceiver.NumberReceiverFacade;

public class ResultCheckerFacadeTest {

    @Test
    public void f() {
        // given
        NumberReceiverFacade numberReceiverFacade = Mockito.mock(NumberReceiverFacade.class);
        when(numberReceiverFacade.usersNumbers(any())).thenReturn(List.of());
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerFacade();;

        // when
        // then
    }
}
