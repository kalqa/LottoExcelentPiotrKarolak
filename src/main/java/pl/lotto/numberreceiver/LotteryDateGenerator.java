package pl.lotto.numberreceiver;


import java.time.LocalDateTime;

class LotteryDateGenerator {


    public LocalDateTime GenerateLotteryDate(String message) throws ValidationExeption {
        if (message.equals("success"))
            return LocalDateTime.now();


        throw new ValidationExeption();
    }
}