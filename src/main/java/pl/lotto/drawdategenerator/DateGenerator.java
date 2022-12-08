package pl.lotto.drawdategenerator;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import static java.time.LocalDateTime.of;

public class DateGenerator {

    private final Clock clock;
    private final int LOTTERY_HOUR = 20;
    private final int LOTTERY_MINUTES = 0;


    public DateGenerator(Clock clock) {
        this.clock = clock;
    }


    public LocalDateTime generateDrawDate(LocalDateTime userTicketCreatedTime) {
        if (isSaturday(userTicketCreatedTime) && isBeforeLotteryHour(userTicketCreatedTime)) {
            return of(userTicketCreatedTime.getYear(),
                    userTicketCreatedTime.getMonth(),
                    userTicketCreatedTime.getDayOfMonth(),
                    LOTTERY_HOUR, LOTTERY_MINUTES);
        }
        TemporalAdjuster nextSaturday = TemporalAdjusters.next(DayOfWeek.SATURDAY);
        return userTicketCreatedTime.with(nextSaturday)
                .withHour(LOTTERY_HOUR)
                .withMinute(LOTTERY_MINUTES);
    }


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

    public LocalDateTime previousDrawDate(LocalDateTime date) {
        LocalDateTime nextDrawDate = generateDrawDate(date);
        LocalDateTime previousDrawDate = nextDrawDate.minusDays(7);

        return previousDrawDate;
    }
}
