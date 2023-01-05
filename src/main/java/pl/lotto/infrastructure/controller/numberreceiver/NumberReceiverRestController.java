package pl.lotto.infrastructure.controller.numberreceiver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.dto.InputNumbersRequestDto;
import pl.lotto.numberreceiver.dto.NumberReceiverResultDto;

@RestController
public class NumberReceiverRestController {

    private final NumberReceiverFacade numberReceiverFacade;

    public NumberReceiverRestController(NumberReceiverFacade numberReceiverFacade) {
        this.numberReceiverFacade = numberReceiverFacade;
    }

    @PostMapping("/inputNumbers")
    public ResponseEntity<NumberReceiverResultDto> f(@RequestBody InputNumbersRequestDto request) {
        NumberReceiverResultDto numberReceiverResultDto = numberReceiverFacade.inputNumbers(request.numbersFromUser());
        return ResponseEntity.ok(numberReceiverResultDto);
    }
}
