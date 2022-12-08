package pl.lotto.resultchecker;

import java.time.LocalDateTime;

import pl.lotto.numbersgenerator.NumbersGeneratorFacade;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;

public class ResultCheckerFacade {
    NumberReceiverFacade numberReceiverFacade;
    NumbersGeneratorFacade numbersGeneratorFacade;

    ResultCheckerFacade(NumberReceiverFacade numberReceiverFacade, NumbersGeneratorFacade numbersGeneratorFacade) {
        this.numberReceiverFacade = numberReceiverFacade;
        this.numbersGeneratorFacade = numbersGeneratorFacade;
    }

    public void checkWinners(){
        AllNumbersFromUsersDto allNumbersFromUsersDto = numberReceiverFacade.usersNumbers(LocalDateTime.now());
        System.out.println(allNumbersFromUsersDto);
      /*drawDateGeneratorFacade.nextDrawDate();
        numberReceiverFacade.usersNumbers(LocalDateTime.now());
*/


    }
}
