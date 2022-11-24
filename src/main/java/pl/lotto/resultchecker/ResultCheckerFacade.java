package pl.lotto.resultchecker;

import java.time.LocalDateTime;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.dto.AllNumbersFromUsersDto;

public class ResultCheckerFacade {

    NumberReceiverFacade numberReceiverFacade;
//    DrawDateGeneratorFacade drawDateGeneratorFacade;
//    NumbersGeneratorFacade numbersGeneratorFacade;


    ResultCheckerFacade(NumberReceiverFacade numberReceiverFacade) {
        this.numberReceiverFacade = numberReceiverFacade;
    }

    public void f() {
//        drawDateGeneratorFacade.nextDrawDate();
        LocalDateTime now = LocalDateTime.now();
        AllNumbersFromUsersDto allNumbersFromUsersDto = numberReceiverFacade.usersNumbers(now);
//        numbersGeneratorFacade.winningNumbers(LocalDateTime.now());


    }
}
