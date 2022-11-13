package pl.lotto.numberreceiver;



import java.time.LocalDateTime;

class LotteryDateGenerator {


     public LocalDateTime GenerateLotteryDate(String message){
         if (message.length() == 0)
            return LocalDateTime.now();

         return LocalDateTime.of(1980,01,1,0,0);
    }
}