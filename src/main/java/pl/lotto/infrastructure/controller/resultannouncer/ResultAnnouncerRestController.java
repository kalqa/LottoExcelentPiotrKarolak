package pl.lotto.infrastructure.controller.resultannouncer;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import pl.lotto.resultannoucer.ResultAnnouncerDto;
import pl.lotto.resultannoucer.ResultAnnouncerFacade;

@RestController
public class ResultAnnouncerRestController {


    private final ResultAnnouncerFacade resultAnnouncerFacade;

    public ResultAnnouncerRestController(ResultAnnouncerFacade resultAnnouncerFacade) {
        this.resultAnnouncerFacade = resultAnnouncerFacade;
    }


    @GetMapping("/getwinners/{id}")
    public ResponseEntity<ResultAnnouncerDto> getWinners(@PathVariable String id){
        ResultAnnouncerDto resultAnnouncerDto = resultAnnouncerFacade.checkWinner(id);
        return ResponseEntity.ok(resultAnnouncerDto);
    }


}
