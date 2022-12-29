package pl.lotto.resultchecker;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
                        new LotteryTicketDto(List.of(1, 2, 3, 4, 5, 6), "id",LocalDateTime.of(2022,12,24,20,0,0)),
                        new LotteryTicketDto(List.of(1, 22, 13, 44, 55, 76), "id2",LocalDateTime.of(2022,12,24,20,0,0)),
                        new LotteryTicketDto(List.of(11, 22, 33, 45, 54, 56), "id3",LocalDateTime.of(2022,12,24,20,0,0)),
                        new LotteryTicketDto(List.of(12, 24, 37, 44, 5, 6), "id4",LocalDateTime.of(2022,12,24,20,0,0)),
                        new LotteryTicketDto(List.of(11, 22, 36, 74, 53, 65), "id5", LocalDateTime.of(2022,12,24,20,0,0))
                )
                ));
        // when
        new ResultCheckerFacade(numberReceiverFacade, numbersGeneratorFacade).checkWinners();

        //then

    }
}
