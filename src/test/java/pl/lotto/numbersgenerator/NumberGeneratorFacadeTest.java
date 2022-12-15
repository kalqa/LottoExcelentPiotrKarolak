package pl.lotto.numbersgenerator;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static pl.lotto.numbersgenerator.WinningNumberGenerator.MAX_NUMBER;

public class NumberGeneratorFacadeTest {

    @Test
    public void should_return_number_in_range_1_between_99() {
        //given
        NumbersGeneratorFacade numbersGeneratorFacade = new NumbersGeneratorFacade(new WinningNumberGenerator());
        //when
        WinningNumbersDto winningNumbersDto = numbersGeneratorFacade.generateWinningNumbers();
        //then
        List<Integer> winningNumbers = winningNumbersDto.winningNumbers();
        assertThat(winningNumbers.stream().noneMatch(this::isInRange)).isTrue();
    }

    @Test
    public void should_have_exactly_six_numbers() {
        //given
        NumbersGeneratorFacade numbersGeneratorFacade = new NumbersGeneratorFacade(new WinningNumberGenerator());
        //when
        List<Integer> winningNumbers = numbersGeneratorFacade.generateWinningNumbers().winningNumbers();
        //then
        assertThat(winningNumbers.stream()).isNotEmpty();
        assertThat(winningNumbers.stream().count()).isEqualTo(6);

    }

    private boolean isInRange(Integer number) {
        return number > MAX_NUMBER || number < 1;
    }

}
