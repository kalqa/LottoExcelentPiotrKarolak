package pl.lotto.numberreceiver;



import java.time.LocalDateTime;

class LotteryDateGenerator {


     public LocalDateTime GenerateLotteryDate(String message){
         if (message.length() == 0)
            return LocalDateTime.now();



         return null;
    }
}