package pl.lotto.resultannoucer;


import pl.lotto.resultchecker.ResultCheckerFacade;

public class ResultAnnouncerFacade {

    private final ResultCheckerFacade resultCheckerFacade;
    private final ResponseCreator responseCreator;

    public ResultAnnouncerFacade(ResultCheckerFacade resultCheckerFacade, ResponseCreator responseCreator) {
        this.resultCheckerFacade = resultCheckerFacade;
        this.responseCreator = responseCreator;
    }

    public ResultAnnouncerDto checkWinner(String ticketId) {
        boolean isWinner = resultCheckerFacade.isWinner(ticketId);
        return responseCreator.createResponse(ticketId, isWinner);
    }
}
