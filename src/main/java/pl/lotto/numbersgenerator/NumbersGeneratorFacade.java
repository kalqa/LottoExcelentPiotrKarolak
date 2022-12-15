
package pl.lotto.numbersgenerator;

import java.util.List;

public class NumbersGeneratorFacade {

    WinningNumberGenerator winningNumberGenerator;

    public NumbersGeneratorFacade(WinningNumberGenerator winningNumberGenerator) {
        this.winningNumberGenerator = winningNumberGenerator;
    }

    public WinningNumbersDto generateWinningNumbers() {
        List<Integer> winningNumbers = winningNumberGenerator.generateWinningNumberList();
        return new WinningNumbersDto(winningNumbers);
    }

}
