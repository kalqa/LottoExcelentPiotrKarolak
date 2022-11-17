package pl.lotto.numberreceiver.dto;


import java.time.LocalDateTime;

public record NumberReceiverResultDto(String message, LocalDateTime lotteryIdGeneratedTime, String lotteryId) {


    public NumberReceiverResultDto(String message){
        this(message,null,null);
    }


}
