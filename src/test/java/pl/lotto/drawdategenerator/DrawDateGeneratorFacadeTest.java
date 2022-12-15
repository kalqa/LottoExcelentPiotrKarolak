package pl.lotto.drawdategenerator;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Test;
import pl.lotto.drawdategenerator.dto.DrawDateDto;
import static org.assertj.core.api.Assertions.assertThat;

public class DrawDateGeneratorFacadeTest {


    @Test
    public void should_return_saturday_at_eight_pm() {
        //given
        LocalDateTime today = LocalDateTime.of(2022, Month.DECEMBER, 1, 15, 0);
        Clock clock = Clock.fixed(today.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
        DrawDateGeneratorFacade drawDateGeneratorFacade = new DrawDateGeneratorConfiguration().drawDateGeneratorFacadeForTest(clock);
        //when
        DrawDateDto drawDateDto = drawDateGeneratorFacade.generateNextDrawDate(today);
        //then
        LocalDateTime expectedDate = LocalDateTime.of(2022, Month.DECEMBER, 3, 20, 0);
        assertThat(drawDateDto.drawDate()).isEqualTo(expectedDate);
    }

    @Test
    public void asdasd() {
        //given
        LocalDateTime today = LocalDateTime.of(2022, Month.DECEMBER, 3, 20, 0);
        Clock clock = Clock.fixed(today.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
        DrawDateGeneratorFacade drawDateGeneratorFacade = new DrawDateGeneratorConfiguration().drawDateGeneratorFacadeForTest(clock);
        //when
        DrawDateDto drawDateDto = drawDateGeneratorFacade.generateNextDrawDate(today);
        //then
        LocalDateTime expectedDate = LocalDateTime.of(2022, Month.DECEMBER, 10, 20, 0);
        assertThat(drawDateDto.drawDate()).isEqualTo(expectedDate);
    }

    @Test
    public void asdasd22() {
        //given
        LocalDateTime today = LocalDateTime.of(2022, Month.DECEMBER, 3, 18, 45);
        Clock clock = Clock.fixed(today.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
        DrawDateGeneratorFacade drawDateGeneratorFacade = new DrawDateGeneratorConfiguration().drawDateGeneratorFacadeForTest(clock);
        //when
        DrawDateDto drawDateDto = drawDateGeneratorFacade.generateNextDrawDate(today);
        //then
        LocalDateTime expectedDate = LocalDateTime.of(2022, Month.DECEMBER, 3, 20, 0);
        assertThat(drawDateDto.drawDate()).isEqualTo(expectedDate);
    }


}
