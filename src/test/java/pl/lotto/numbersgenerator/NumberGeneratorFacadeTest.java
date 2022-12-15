package pl.lotto.numbersgenerator;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorFacadeTest {

    @Test
    public void should_return_number_in_range_1_between_99(){
        //given
        NumbersGeneratorFacade numbersGeneratorFacade = new NumbersGeneratorFacade(new WinningNumberGenerator());
        List<Integer> winningNumbers;
        //when
        winningNumbers = numbersGeneratorFacade.generateWinningNumbers().winningNumbers();
        //then
        assertThat(winningNumbers.stream().noneMatch(this::isInRange)).isTrue();
    }

    @Test
    public void should_have_exactly_six_numbers(){
        //given
        NumbersGeneratorFacade numbersGeneratorFacade = new NumbersGeneratorFacade(new WinningNumberGenerator());
        List<Integer> winningNumbers;
        //when
        winningNumbers = numbersGeneratorFacade.generateWinningNumbers().winningNumbers();
        //then
        assertThat(winningNumbers.stream()).isNotEmpty();
        assertThat(winningNumbers.stream().count()).isEqualTo(6);

    }





    private boolean isInRange(Integer integer) {
        return integer > 99 || integer < 1;
    }


}
