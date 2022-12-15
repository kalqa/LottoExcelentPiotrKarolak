
package pl.lotto.numbersgenerator;

import pl.lotto.numberreceiver.NumberReceiverFacade;

import java.util.List;

public class NumbersGeneratorFacade {

   WinningNumberGenerator winningNumberGenerator;

    public NumbersGeneratorFacade(WinningNumberGenerator winningNumberGenerator){
       this.winningNumberGenerator = winningNumberGenerator;
    }


    public WinningNumbersDto generateWinningNumbers() {

        return new WinningNumbersDto( winningNumberGenerator.generateWinningNumberList());}


}
