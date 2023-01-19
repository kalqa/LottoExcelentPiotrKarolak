package pl.lotto.infrastructure.controller.numbersgenerator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lotto.numbersgenerator.NumbersGeneratorFacade;
import pl.lotto.numbersgenerator.WinningNumbersDto;

import java.util.List;

@RestController
public class NumbersGeneratorRestController {


    private final NumbersGeneratorFacade numbersGeneratorFacade;


    public NumbersGeneratorRestController(NumbersGeneratorFacade numbersGeneratorFacade) {
        this.numbersGeneratorFacade = numbersGeneratorFacade;
    }

    @GetMapping("/generateWinningNumbers")
    public WinningNumbersDto generateWinningNumbers(){

        return numbersGeneratorFacade.generateWinningNumbers();
    }
}
