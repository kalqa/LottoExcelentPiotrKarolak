package pl.lotto.numbersgenerator;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.lotto.drawdategenerator.DrawDateGeneratorFacade;
import pl.lotto.drawdategenerator.dto.DrawDateDto;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.lotto.numbersgenerator.WinningNumberGenerator.MAX_NUMBER;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
public class NumberGeneratorFacadeTest {

    @Test
    public void should_return_number_in_range_1_between_99() {
        //given
        WinningNumberRepository winningNumberRepository = new NumbersGeneratorRepositoryTestImpl();
        DrawDateGeneratorFacade drawDateGeneratorFacade = Mockito.mock(DrawDateGeneratorFacade.class);
        NumbersGeneratorFacade numbersGeneratorFacade = new NumbersGeneratorConfiguration().numbersGeneratorFacadeForTest(winningNumberRepository,drawDateGeneratorFacade);
        LocalDateTime drawDate = LocalDateTime.of(2022, Month.NOVEMBER, 19, 20, 0, 0);
        when(drawDateGeneratorFacade.generateNextDrawDate(any())).thenReturn(DrawDateDto.builder().drawDate(drawDate).build());
        //when
        WinningNumbersDto winningNumbersDto = numbersGeneratorFacade.generateWinningNumbers();
        //then
        List<Integer> winningNumbers = winningNumbersDto.winningNumbers();
        assertThat(winningNumbers.stream().noneMatch(this::isInRange)).isTrue();
    }

    @Test
    public void should_have_exactly_six_numbers() {
        //given
        WinningNumberRepository winningNumberRepository = new NumbersGeneratorRepositoryTestImpl();
        DrawDateGeneratorFacade drawDateGeneratorFacade = Mockito.mock(DrawDateGeneratorFacade.class);
        NumbersGeneratorFacade numbersGeneratorFacade = new NumbersGeneratorConfiguration().numbersGeneratorFacadeForTest(winningNumberRepository,drawDateGeneratorFacade);
        LocalDateTime drawDate = LocalDateTime.of(2022, Month.NOVEMBER, 19, 20, 0, 0);
        when(drawDateGeneratorFacade.generateNextDrawDate(any())).thenReturn(DrawDateDto.builder().drawDate(drawDate).build());
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
