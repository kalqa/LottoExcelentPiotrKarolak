
package pl.lotto.numbersgenerator;

import java.time.LocalDateTime;
import java.util.List;

public class NumbersGeneratorFacade {

     private WinningNumberGenerator winningNumberGenerator;

    public NumbersGeneratorFacade(WinningNumberGenerator winningNumberGenerator) {
        this.winningNumberGenerator = winningNumberGenerator;
    }

    public WinningNumbersDto generateWinningNumbers() {
        List<Integer> winningNumbers = winningNumberGenerator.generateWinningNumberList();
        return new WinningNumbersDto(winningNumbers);
    }

}
