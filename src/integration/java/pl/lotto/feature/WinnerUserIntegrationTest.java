package pl.lotto.feature;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import pl.lotto.BaseIntegrationTest;
import pl.lotto.numbersgenerator.NumbersGeneratorFacade;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class WinnerUserIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private NumbersGeneratorFacade numbersGeneratorFacade;

    @Test
    public void should_user_play_and_win_after_7_days() throws Exception {
        // step 1: user gave six numbers
        // given
        // when
        ResultActions perform = mockMvc.perform(post("/inputNumbers")
                .content("{\"numbersFromUser\":[1,2,3,4,5,6]}")
                .contentType(MediaType.APPLICATION_JSON_VALUE));
        // then
        MvcResult mvcResult = perform
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"message\":\"success\"," +
                                "\"drawDate\":\"2023-01-21T20:00:00\"}"))
                .andReturn();

        // step 2: system generates winning numbers
/*
        await().atMost(10, SECONDS)
                .pollInterval(1, SECONDS)
                .until(()->{
                    numbersGeneratorFacade.generateWinningNumbers();
                });

        await().atMost(10, SECONDS)
                .pollInterval(Duration.ofSeconds(1))
                .until(() -> !numbersGeneratorFacade.retrieve(result.drawDate()).winningNumbers().isEmpty());*/
      /*  MvcResult mvcNumbergeneratorResult = perform
                .andExpect(status().isOk())
                .andExpect(content().json("{\""}"))
        // given*/
        // when
        // then

        // step 3: user wants to know if won
        // given
        // when
        // then
    }
}
