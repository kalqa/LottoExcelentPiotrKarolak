package pl.lotto.resultannoucer;


import pl.lotto.resultchecker.ResultCheckerFacade;

public class ResultAnnoucerFacade {


    private final ResultCheckerFacade resultCheckerFacade;
    private final ResponseCreator responseCreator;

    public ResultAnnoucerFacade(ResultCheckerFacade resultCheckerFacade, ResponseCreator responseCreator) {
        this.resultCheckerFacade = resultCheckerFacade;
        this.responseCreator = responseCreator;
    }


    public ResultAnnoucerDto getWinners(String idTicket) {
        boolean isWinning = resultCheckerFacade.IsWinner(idTicket);
        ResultAnnoucerDto result = responseCreator.createRespone(idTicket, isWinning);
        return result;

    }


}
