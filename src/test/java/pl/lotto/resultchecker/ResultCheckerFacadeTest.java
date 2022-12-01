package pl.lotto.resultchecker;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;
import pl.lotto.numbersgenerator.NumbersGeneratorFacade;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ResultCheckerFacadeTest {


    @Test
    public void f() {
        // given
        NumberReceiverFacade numberReceiverFacade = Mockito.mock(NumberReceiverFacade.class);
        NumbersGeneratorFacade numbersGeneratorFacade = Mockito.mock(NumbersGeneratorFacade.class);
        when(numberReceiverFacade.usersNumbers(any())).thenReturn(
                new AllNumbersFromUsersDto(List.of(
                        new LotteryTicketDto(List.of(1, 2, 3, 4, 5, 6), "id"),
                        new LotteryTicketDto(List.of(1, 2, 3, 4, 5, 6), "id2"),
                        new LotteryTicketDto(List.of(1, 2, 3, 4, 5, 6), "id3"),
                        new LotteryTicketDto(List.of(1, 2, 3, 4, 5, 6), "id4"),
                        new LotteryTicketDto(List.of(1, 2, 3, 4, 5, 6), "id5")
                )
                ));
        // when
        new ResultCheckerFacade(numberReceiverFacade, numbersGeneratorFacade).checkWinners();
    }
}
