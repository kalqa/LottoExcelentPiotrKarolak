package pl.lotto.numberreceiver;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.lotto.drawdategenerator.DrawDateGeneratorFacade;
import pl.lotto.drawdategenerator.dto.DrawDateDto;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;
import pl.lotto.numberreceiver.dto.NumberReceiverResultDto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class NumberReceiverFacadeTest {

    Clock clock = Clock.systemUTC();
    NumberReceiverRepository repository = new NumberReceiverRepositoryTestImpl();

    @Test
    public void should_return_success_when_user_gave_six_numbers_in_correct_range() {
        // given
        DrawDateGeneratorFacade drawDateFacade = Mockito.mock(DrawDateGeneratorFacade.class);
        LocalDateTime drawDate = LocalDateTime.of(2022, Month.NOVEMBER, 19, 20, 0, 0);
        when(drawDateFacade.generateNextDrawDate(any())).thenReturn(DrawDateDto.builder().drawDate(drawDate).build());
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository, drawDateFacade);
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.message()).isEqualTo("success");
    }

    @Test
    public void should_return_unique_id_when_user_gave_correct_input() {
        // given
        DrawDateGeneratorFacade drawDateFacade = Mockito.mock(DrawDateGeneratorFacade.class);
        LocalDateTime drawDate = LocalDateTime.of(2022, Month.NOVEMBER, 19, 20, 0, 0);
        when(drawDateFacade.generateNextDrawDate(any())).thenReturn(DrawDateDto.builder().drawDate(drawDate).build());
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository, drawDateFacade);
        Pattern UUID_REGEX =
                Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
        List<Integer> numberFromUser = List.of(1, 2, 3, 4, 6, 7);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numberFromUser);
        //then
        assertTrue(UUID_REGEX.matcher(result.lotteryId()).matches());

    }

    @Test
    public void should_return_lottery_ticket_date_when_played_on_friday() {
        // given
       /* LocalDateTime today = LocalDateTime.of(2022, Month.NOVEMBER, 17, 11, 0, 0);
        Clock clock = Clock.fixed(today.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository);*/
        DrawDateGeneratorFacade drawDateFacade = Mockito.mock(DrawDateGeneratorFacade.class);
        LocalDateTime drawDate = LocalDateTime.of(2022, Month.NOVEMBER, 19, 20, 0, 0);
        when(drawDateFacade.generateNextDrawDate(any())).thenReturn(DrawDateDto.builder().drawDate(drawDate).build());
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository, drawDateFacade);
        List<Integer> numberFromUser = List.of(1, 2, 3, 4, 6, 7);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numberFromUser);
        //then
        LocalDateTime ticketDate = LocalDateTime.of(2022, Month.NOVEMBER, 19, 20, 0, 0);
        assertThat(result.drawDate()).isEqualTo(ticketDate);
    }

    @Test
    public void should_return_failure_when_user_gave_less_than_six_numbers() {
        // given
        DrawDateGeneratorFacade drawDateFacade = Mockito.mock(DrawDateGeneratorFacade.class);
        LocalDateTime drawDate = LocalDateTime.of(2022, Month.NOVEMBER, 19, 20, 0, 0);
        when(drawDateFacade.generateNextDrawDate(any())).thenReturn(DrawDateDto.builder().drawDate(drawDate).build());
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository, drawDateFacade);
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.message()).isEqualTo("not six numbers,user gave duplicate");
    }

    @Test
    public void should_return_failure_when_user_gave_more_than_six_numbers() {
        // given
        DrawDateGeneratorFacade drawDateFacade = Mockito.mock(DrawDateGeneratorFacade.class);
        LocalDateTime drawDate = LocalDateTime.of(2022, Month.NOVEMBER, 19, 20, 0, 0);
        when(drawDateFacade.generateNextDrawDate(any())).thenReturn(DrawDateDto.builder().drawDate(drawDate).build());
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository, drawDateFacade);
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6, 7);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        assertThat(result.message()).isEqualTo("not six numbers,user gave duplicate");
    }

    @Test
    public void should_return_failure_when_user_gave_at_least_one_duplicate() {
        //given
        DrawDateGeneratorFacade drawDateFacade = Mockito.mock(DrawDateGeneratorFacade.class);
        LocalDateTime drawDate = LocalDateTime.of(2022, Month.NOVEMBER, 19, 20, 0, 0);
        when(drawDateFacade.generateNextDrawDate(any())).thenReturn(DrawDateDto.builder().drawDate(drawDate).build());
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository, drawDateFacade);
        List<Integer> numbersFromUser = List.of(1, 2, 3, 3, 4, 5);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        assertThat(result.message()).isEqualTo("user gave duplicate");

    }

    @Test
    public void should_return_failure_when_user_gave_at_least_one_out_of_range() {
        //given
        DrawDateGeneratorFacade drawDateFacade = Mockito.mock(DrawDateGeneratorFacade.class);
        LocalDateTime drawDate = LocalDateTime.of(2022, Month.NOVEMBER, 19, 20, 0, 0);
        when(drawDateFacade.generateNextDrawDate(any())).thenReturn(DrawDateDto.builder().drawDate(drawDate).build());
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository, drawDateFacade);
        List<Integer> numberFromUser = List.of(1, 2, 3, 4, 6, 100000);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numberFromUser);
        //then
        assertThat(result.message()).isEqualTo("number gave number out of range");
    }


    @Test
    public void should_return_null_when_user_gave_out_of_range_number() {
        // given
        DrawDateGeneratorFacade drawDateFacade = Mockito.mock(DrawDateGeneratorFacade.class);
        LocalDateTime drawDate = LocalDateTime.of(2022, Month.NOVEMBER, 19, 20, 0, 0);
        when(drawDateFacade.generateNextDrawDate(any())).thenReturn(DrawDateDto.builder().drawDate(drawDate).build());
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository, drawDateFacade);
        List<Integer> numberFromUser = List.of(1, 2, 3, 4, 6, 1000);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numberFromUser);
        //then
        assertThat(result.lotteryId()).isEqualTo(null);

    }

    @Test
    public void should_return_null_when_user_gave_less_numbers() {
        // given
        DrawDateGeneratorFacade drawDateFacade = Mockito.mock(DrawDateGeneratorFacade.class);
        LocalDateTime drawDate = LocalDateTime.of(2022, Month.NOVEMBER, 19, 20, 0, 0);
        when(drawDateFacade.generateNextDrawDate(any())).thenReturn(DrawDateDto.builder().drawDate(drawDate).build());
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository, drawDateFacade);
        List<Integer> numberFromUser = List.of(1, 2, 3, 4, 6);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numberFromUser);
        //then
        assertThat(result.lotteryId()).isEqualTo(null);

    }

    @Test
    public void should_return_null_when_user_gave_more_then_six_numbers() {
        // given
        DrawDateGeneratorFacade drawDateFacade = Mockito.mock(DrawDateGeneratorFacade.class);
        LocalDateTime drawDate = LocalDateTime.of(2022, Month.NOVEMBER, 19, 20, 0, 0);
        when(drawDateFacade.generateNextDrawDate(any())).thenReturn(DrawDateDto.builder().drawDate(drawDate).build());
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository, drawDateFacade);
        List<Integer> numberFromUser = List.of(1, 2, 3, 4, 5, 6, 7);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numberFromUser);
        //then
        assertThat(result.lotteryId()).isEqualTo(null);

    }

    @Test
    public void should_return_all_numbers_for_given_date() {
        // given
//        LocalDateTime today = LocalDateTime.of(2022, Month.NOVEMBER, 17, 11, 0, 0);
//        Clock clock = Clock.fixed(today.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
        DrawDateGeneratorFacade drawDateFacade = Mockito.mock(DrawDateGeneratorFacade.class);
        LocalDateTime drawDate = LocalDateTime.of(2022, Month.NOVEMBER, 19, 20, 0, 0);
        when(drawDateFacade.generateNextDrawDate(any())).thenReturn(DrawDateDto.builder().drawDate(drawDate).build());


        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository, drawDateFacade);
        List<Integer> numberFromUser = List.of(1, 2, 3, 4, 5, 6);
        NumberReceiverResultDto numberReceiverResultDto = numberReceiverFacade.inputNumbers(numberFromUser);

        LocalDateTime drawDateSentToUser = numberReceiverResultDto.drawDate();


//        LocalDateTime drawDate = LocalDateTime.of(2022, Month.NOVEMBER, 17, 11, 0, 0);
        //when
        AllNumbersFromUsersDto result = numberReceiverFacade.usersNumbers(drawDate);
        //then
        assertThat(result.allNumbers()).isNotEmpty();
        assertThat(result.allNumbers().get(0).numbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void should_return_no_tickets_when_nobody_played() {
        // given
        DrawDateGeneratorFacade drawDateFacade = Mockito.mock(DrawDateGeneratorFacade.class);
        LocalDateTime drawDate = LocalDateTime.of(2022, Month.NOVEMBER, 19, 20, 0, 0);
        when(drawDateFacade.generateNextDrawDate(any())).thenReturn(DrawDateDto.builder().drawDate(drawDate).build());
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest(clock, repository, drawDateFacade);
        //when
        AllNumbersFromUsersDto result = numberReceiverFacade.usersNumbers(drawDate);
        //then
        assertThat(result.allNumbers()).isEmpty();
    }
}
