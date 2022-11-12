package pl.lotto.numberreceiver;

import java.util.List;
import org.junit.jupiter.api.Test;
import pl.lotto.numberreceiver.dto.NumberReceiverResultDto;
import static org.assertj.core.api.Assertions.assertThat;

public class NumberReceiverFacadeTest {

    @Test
    public void should_return_success_when_user_gave_six_numbers_in_correct_range() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest();
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.message()).isEqualTo("success");
    }

    @Test
    public void should_return_unique_id_when_user_gave_correct_input() {

    }

    @Test
    public void should_return_correct_draw_date_when_user_gave_correct_input() {

    }

    @Test
    public void should_return_failure_when_user_gave_less_than_six_numbers() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest();
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.message()).isEqualTo("not six numbers,user gave duplicate");
    }

    @Test
    public void should_return_failure_when_user_gave_more_than_six_numbers() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest();
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6, 7);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        assertThat(result.message()).isEqualTo("not six numbers,user gave duplicate");
    }

    @Test
    public void should_return_failure_when_user_gave_at_least_one_duplicate() {
        //given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest();
        List<Integer> numbersFromUser = List.of(1, 2, 3, 3, 4, 5);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        assertThat(result.message()).isEqualTo("user gave duplicate");

    }

    @Test
    public void should_return_failure_when_user_gave_at_least_one_out_of_range() {
        //given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().numberReceiverFacadeForTest();
        List<Integer> numberFromUser = List.of(1, 2, 3, 4, 6, 100000);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numberFromUser);
        //then
        assertThat(result.message()).isEqualTo("number gave number out of range");
    }




}
