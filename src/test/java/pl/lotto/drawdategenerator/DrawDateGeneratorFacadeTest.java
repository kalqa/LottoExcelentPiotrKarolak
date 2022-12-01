//package pl.lotto.drawdategenerator;
//
//import java.time.Clock;
//import java.time.LocalDateTime;
//import java.time.Month;
//import java.time.ZoneId;
//import java.time.ZoneOffset;
//import org.junit.jupiter.api.Test;
//import pl.lotto.drawdategenerator.DrawDateGeneratorConfiguration;
//import pl.lotto.drawdategenerator.DrawDateGeneratorFacade;
//
//public class DrawDateGeneratorFacadeTest {
//
//
////    @Test
////    public void should_return_saturday_at_eight_pm() {
////        //given
////        LocalDateTime today = LocalDateTime.of(2022, Month.DECEMBER, 1, 15, 00);
////        Clock clock = Clock.fixed(today.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
////        DrawDateGeneratorFacade drawDateGeneratorFacade = new DrawDateGeneratorConfiguration().drawDateGeneratorFacadeForTest(clock);
////        //when
////        drawDateGeneratorFacade.previousDrawDate();
////        //then
////
////    }
//
//
//    @Test
//    public void should_return_saturday_at_eight_pm() {
//        //given
//        DateGenerator dateGenerator = new DateGenerator(clock);
//        DrawDateGeneratorFacade drawDateFacade = new DrawDateGeneratorFacade(dateGenerator);
//        //when
//        DrawDateDto drawDateDto = drawDateFacade.previousDrawDate();
//        //then
//    }
//
//
//}
