package pl.lotto.DrawDateGenerator;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

class DateGenerator {

    private final Clock clock;
    private final int LOTTERY_HOUR = 20;


    public DateGenerator(Clock clock) {
        this.clock = clock;
    }


/*    public LocalDateTime generateDrawDate(LocalDateTime userTicketCreatedTime) {
        if (isSaturday(userTicketCreatedTime)
                && isBeforeLotteryHour(userTicketCreatedTime)) {
        }

    }*/





    private boolean isSaturday(LocalDateTime userTicketCreatedTime) {
        if (userTicketCreatedTime.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            return true;
        }
        return false;
    }

    private boolean isBeforeLotteryHour(LocalDateTime userTicketCreatedTime) {
        if (userTicketCreatedTime.getHour() < LOTTERY_HOUR) {
            return true;
        }
        return false;
    }

}
