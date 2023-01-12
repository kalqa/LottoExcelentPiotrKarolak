package pl.lotto.resultannoucer;

public class ResponseCreator {


    public ResultAnnoucerDto createRespone(String idTicket, boolean isWinning) {
        if(isWinning){
            return new ResultAnnoucerDto(isWinning,idTicket,WinningMessage.WIN.message);
        }
        return new ResultAnnoucerDto(isWinning,idTicket,WinningMessage.LOSE.message);
    }
}
