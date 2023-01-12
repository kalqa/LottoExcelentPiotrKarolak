package pl.lotto.resultannoucer;

import static pl.lotto.resultannoucer.WinningMessage.*;

class ResponseCreator {

    ResultAnnouncerDto createResponse(String ticketId, boolean isWinner) {
        if (isWinner) {
            return new ResultAnnouncerDto(isWinner, ticketId, WIN.message);
        }
        return new ResultAnnouncerDto(isWinner, ticketId, LOSE.message);
    }
}
