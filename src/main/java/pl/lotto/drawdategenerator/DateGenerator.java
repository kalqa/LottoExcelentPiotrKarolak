package pl.lotto.drawdategenerator;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class DateGenerator {

    private static final int OFFSET = 1;

    private final Clock clock;
    private final int LOTTERY_HOUR = 20;
    private final int LOTTERY_MINUTES = 0;


    public DateGenerator(Clock clock) {
        this.clock = clock;
    }


    public LocalDateTime generateDrawDate(LocalDateTime userTicketCreatedTime) {
        LocalDateTime now = LocalDateTime.now(clock);
        if (isSaturday(now) && isEightPm(now)) {
            return now.with(TemporalAdjusters.next(DayOfWeek.SATURDAY))
                    .withHour(LOTTERY_HOUR)
                    .withMinute(LOTTERY_MINUTES)
                    .withSecond(0)
                    .withNano(0);
        }

        return now.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY))
                .withHour(LOTTERY_HOUR)
                .withMinute(LOTTERY_MINUTES)
                .withSecond(0)
                .withNano(0);
    }


    private boolean isSaturday(LocalDateTime userTicketCreatedTime) {
        return userTicketCreatedTime.getDayOfWeek().equals(DayOfWeek.SATURDAY);
    }

    private boolean isEightPm(LocalDateTime userTicketCreatedTime) {
        return userTicketCreatedTime.getHour() - OFFSET == LOTTERY_HOUR;
    }

}
