package pl.lotto.numberreceiver;


import java.time.LocalDateTime;

class LotteryDateGenerator {

    private static final String CORRECT_MESSAGE = "success";

    public LocalDateTime GenerateLotteryDate(String message) throws ValidationExeption {
        if (isCorrectMessage(message))
            return LocalDateTime.now();

        throw new ValidationExeption();
    }

    private boolean isCorrectMessage(String message){
        if (message.equals(CORRECT_MESSAGE)){
            return true;
        }
        return false;
    }

}