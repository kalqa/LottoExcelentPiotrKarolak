package pl.lotto.resultchecker;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;
import pl.lotto.numberreceiver.dto.LotteryTicketDto;
import pl.lotto.numbersgenerator.NumbersGeneratorFacade;
import pl.lotto.numbersgenerator.WinningNumbersDto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ResultCheckerFacadeTest {


    @Test
    public void should_return_winning_tickets_list_from_all_tickets_for_draw_date() {
        // given
        NumberReceiverFacade numberReceiverFacade = Mockito.mock(NumberReceiverFacade.class);
        NumbersGeneratorFacade numbersGeneratorFacade = Mockito.mock(NumbersGeneratorFacade.class);
        WinnerChecker winnerChecker = new WinnerChecker();
        ResultCheckerRepository resultCheckerRepository = new ResultCheckerRepositoryTestImpl();
        LocalDateTime drawTime = LocalDateTime.of(2022, 12, 24, 20, 0, 0);
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerFacade(numberReceiverFacade, numbersGeneratorFacade, winnerChecker, resultCheckerRepository);
        List<LotteryTicketDto> winningTickets;
        when(numbersGeneratorFacade.generateWinningNumbers()).thenReturn(new WinningNumbersDto(List.of(1, 2, 3, 4, 5, 6)));
        when(numberReceiverFacade.usersNumbers(any())).thenReturn(
                new AllNumbersFromUsersDto(List.of(
                        new LotteryTicketDto(List.of(1, 2, 3, 4, 5, 6), "id", LocalDateTime.of(2022, 12, 24, 20, 0, 0)),
                        new LotteryTicketDto(List.of(1, 22, 13, 44, 55, 76), "id2", LocalDateTime.of(2022, 12, 24, 20, 0, 0)),
                        new LotteryTicketDto(List.of(11, 22, 33, 45, 54, 56), "id3", LocalDateTime.of(2022, 12, 24, 20, 0, 0)),
                        new LotteryTicketDto(List.of(12, 24, 37, 44, 5, 6), "id4", LocalDateTime.of(2022, 12, 24, 20, 0, 0)),
                        new LotteryTicketDto(List.of(11, 22, 36, 74, 53, 65), "id5", LocalDateTime.of(2022, 12, 24, 20, 0, 0)),
                        new LotteryTicketDto(List.of(1, 2, 3, 4, 5, 6), "id6", LocalDateTime.of(2022, 12, 24, 20, 0, 0))
                )
                ));
        // when
        winningTickets = resultCheckerFacade.checkWinners(drawTime);

        //then
        assertTrue(!winningTickets.isEmpty());
        assertTrue(winningTickets.size() == 2);
    }

    @Test
    public void should_return_empty_winning_tickets_list_from_all_tickets_for_not_winning_numbers() {
        // given
        NumberReceiverFacade numberReceiverFacade = Mockito.mock(NumberReceiverFacade.class);
        NumbersGeneratorFacade numbersGeneratorFacade = Mockito.mock(NumbersGeneratorFacade.class);
        ResultCheckerRepository resultCheckerRepository = new ResultCheckerRepositoryTestImpl();
        WinnerChecker winnerChecker = new WinnerChecker();
        LocalDateTime drawTime = LocalDateTime.of(2022, 12, 24, 20, 0, 0);
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerFacade(numberReceiverFacade, numbersGeneratorFacade, winnerChecker, resultCheckerRepository);
        List<LotteryTicketDto> winningTickets;
        when(numbersGeneratorFacade.generateWinningNumbers()).thenReturn(new WinningNumbersDto(List.of(1, 2, 3, 4, 5, 7)));
        when(numberReceiverFacade.usersNumbers(any())).thenReturn(
                new AllNumbersFromUsersDto(List.of(
                        new LotteryTicketDto(List.of(1, 2, 3, 4, 5, 6), "id", LocalDateTime.of(2022, 12, 24, 20, 0, 0)),
                        new LotteryTicketDto(List.of(1, 22, 13, 44, 55, 76), "id2", LocalDateTime.of(2022, 12, 24, 20, 0, 0)),
                        new LotteryTicketDto(List.of(11, 22, 33, 45, 54, 56), "id3", LocalDateTime.of(2022, 12, 24, 20, 0, 0)),
                        new LotteryTicketDto(List.of(12, 24, 37, 44, 5, 6), "id4", LocalDateTime.of(2022, 12, 24, 20, 0, 0)),
                        new LotteryTicketDto(List.of(11, 22, 36, 74, 53, 65), "id5", LocalDateTime.of(2022, 12, 24, 20, 0, 0)),
                        new LotteryTicketDto(List.of(1, 2, 3, 4, 5, 6), "id6", LocalDateTime.of(2022, 12, 24, 20, 0, 0))
                )
                ));
        // when
        winningTickets = resultCheckerFacade.checkWinners(drawTime);

        //then
        assertTrue(winningTickets.isEmpty());
    }

  /*  @Test
    public void should_return_true_if_numbers_are_winning() {
        //given
        String lotteryID = "id1";
        NumberReceiverFacade numberReceiverFacade = Mockito.mock(NumberReceiverFacade.class);
        NumbersGeneratorFacade numbersGeneratorFacade = Mockito.mock(NumbersGeneratorFacade.class);
        ResultCheckerRepository resultCheckerRepository = new ResultCheckerRepositoryTestImpl();
        LocalDateTime drawTime = LocalDateTime.of(2022, 12, 24, 20, 0, 0);
        WinnerChecker winnerChecker = new WinnerChecker();
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerFacade(numberReceiverFacade, numbersGeneratorFacade, winnerChecker, resultCheckerRepository);
        LotteryTicketDto lotteryTicketDto = new LotteryTicketDto(List.of(1, 2, 3, 4, 5, 6), lotteryID, drawTime);
        when(numbersGeneratorFacade.generateWinningNumbers()).thenReturn(new WinningNumbersDto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = numbersGeneratorFacade.generateWinningNumbers().winningNumbers();
        PlayerResult playerResult = new PlayerResult(lotteryID,winningNumbers, List.of(lotteryTicketDto), drawTime);
        resultCheckerRepository.save(playerResult);

        //when
        boolean result = resultCheckerFacade.isWinner(lotteryID);

        //then

        assertThat(result == true);
    }


    @Test
    public void should_return_false_if_numbers_are_not_winning() {
        //given
        String lotteryID = "id1";
        NumberReceiverFacade numberReceiverFacade = Mockito.mock(NumberReceiverFacade.class);
        NumbersGeneratorFacade numbersGeneratorFacade = Mockito.mock(NumbersGeneratorFacade.class);
        ResultCheckerRepository resultCheckerRepository = new ResultCheckerRepositoryTestImpl();
        LocalDateTime drawTime = LocalDateTime.of(2022, 12, 24, 20, 0, 0);
        WinnerChecker winnerChecker = new WinnerChecker();
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerFacade(numberReceiverFacade, numbersGeneratorFacade, winnerChecker, resultCheckerRepository);

        LotteryTicketDto lotteryTicketDto = new LotteryTicketDto(List.of(1, 2, 3, 4, 5, 8), lotteryID, drawTime);
        when(numbersGeneratorFacade.generateWinningNumbers()).thenReturn(new WinningNumbersDto(List.of(1, 2, 3, 4, 5, 7)));
        List<Integer> winningNumbers = numbersGeneratorFacade.generateWinningNumbers().winningNumbers();
        PlayerResult playerResult = new PlayerResult(lotteryID,winningNumbers, List.of(lotteryTicketDto), drawTime);
        resultCheckerRepository.save(playerResult);
        //when
        boolean result = resultCheckerFacade.isWinner(lotteryID);

        //then

        assertThat(result == false);
    }
*/

}
