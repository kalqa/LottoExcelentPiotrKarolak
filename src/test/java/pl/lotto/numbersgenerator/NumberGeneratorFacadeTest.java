package pl.lotto.numbersgenerator;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorFacadeTest {

    @Test
    public void should_return_number_in_range_1_between_99(){
        //given
        NumbersGeneratorFacade numbersGeneratorFacade = new NumbersGeneratorFacade();
        List<Integer> winningNumbers;
        //when
        winningNumbers = numbersGeneratorFacade.winningNumbers();
        //then
        // Stream? /robić validator?

    }


}
