
package pl.lotto.numbersgenerator;

import java.util.List;

public class NumbersGeneratorFacade {

   WinningNumberGenerator winningNumberGenerator;


    public List<Integer> winningNumbers() {

        return winningNumberGenerator.generateWinningNumberList();
    }


}
