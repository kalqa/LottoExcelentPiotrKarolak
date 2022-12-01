package pl.lotto.numberreceiver;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;
import pl.lotto.numberreceiver.dto.NumberReceiverResultDto;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberReceiverFacadeTest {

    Clock clock = Clock.systemUTC();
    NumberReceiverRepository repository = new NumberReceiverRepositoryTestImpl();

    @Test
    public void should_return_success_when_user_gave_six_numbers_in_correct_range() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository);
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.message()).isEqualTo("success");
    }

    @Test
    public void should_return_unique_id_when_user_gave_correct_input() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository);
        List<Integer> numberFromUser = List.of(1, 2, 3, 4, 6, 7);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numberFromUser);
        //then
        assertThat(result.lotteryId()).isEqualTo(Long.valueOf(1));

    }

    @Test
    public void should_return_lottery_ticket_date_when_played_on_friday() {
        // given
        LocalDateTime today = LocalDateTime.of(2022, Month.NOVEMBER, 17, 11, 0, 0);
        Clock clock = Clock.fixed(today.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository);
        List<Integer> numberFromUser = List.of(1, 2, 3, 4, 6, 7);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numberFromUser);
        //then
        LocalDateTime ticketDate = LocalDateTime.of(2022, Month.NOVEMBER, 17, 11, 0, 0);
        assertThat(result.lotteryIdGeneratedTime()).isEqualTo(ticketDate);
    }

    @Test
    public void should_return_failure_when_user_gave_less_than_six_numbers() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository);
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.message()).isEqualTo("not six numbers,user gave duplicate");
    }

    @Test
    public void should_return_failure_when_user_gave_more_than_six_numbers() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository);
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6, 7);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        assertThat(result.message()).isEqualTo("not six numbers,user gave duplicate");
    }

    @Test
    public void should_return_failure_when_user_gave_at_least_one_duplicate() {
        //given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository);
        List<Integer> numbersFromUser = List.of(1, 2, 3, 3, 4, 5);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        assertThat(result.message()).isEqualTo("user gave duplicate");

    }

    @Test
    public void should_return_failure_when_user_gave_at_least_one_out_of_range() {
        //given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository);
        List<Integer> numberFromUser = List.of(1, 2, 3, 4, 6, 100000);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numberFromUser);
        //then
        assertThat(result.message()).isEqualTo("number gave number out of range");
    }



    @Test
    public void should_return_null_when_user_gave_out_of_range_number() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository);
        List<Integer> numberFromUser = List.of(1, 2, 3, 4, 6, 1000);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numberFromUser);
        //then
        assertThat(result.lotteryId()).isEqualTo(null);

    }

    @Test
    public void should_return_null_when_user_gave_less_numbers() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository);
        List<Integer> numberFromUser = List.of(1, 2, 3, 4, 6);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numberFromUser);
        //then
        assertThat(result.lotteryId()).isEqualTo(null);

    }

    @Test
    public void should_return_null_when_user_gave_more_then_six_numbers() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository);
        List<Integer> numberFromUser = List.of(1, 2, 3, 4, 5, 6, 7);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numberFromUser);
        //then
        assertThat(result.lotteryId()).isEqualTo(null);

    }

    @Test
    public void should_return_all_numbers_for_given_date() {
        // given
        LocalDateTime today = LocalDateTime.of(2022, Month.NOVEMBER, 17, 11, 0, 0);
        Clock clock = Clock.fixed(today.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository);
        List<Integer> numberFromUser = List.of(1, 2, 3, 4, 5, 6);
        numberReceiverFacade.inputNumbers(numberFromUser);
        //when
        AllNumbersFromUsersDto result = numberReceiverFacade.usersNumbers(LocalDateTime.now());
        //then
        assertThat(result.allNumbers().get(0).numbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void should_return_correct_id_when_user_played() {
        // given
        LocalDateTime today = LocalDateTime.of(2022, Month.NOVEMBER, 17, 11, 0, 0);
        Clock clock = Clock.fixed(today.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository);
        List<Integer> numberFromUser = List.of(1, 2, 3, 4, 5, 6);
        numberReceiverFacade.inputNumbers(numberFromUser);
        //when
        AllNumbersFromUsersDto result = numberReceiverFacade.usersNumbers(LocalDateTime.now());
        //then
        assertThat(result.allNumbers().get(0).numbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }






}
