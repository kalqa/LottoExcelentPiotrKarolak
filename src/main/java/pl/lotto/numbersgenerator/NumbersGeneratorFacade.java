
package pl.lotto.numbersgenerator;

import lombok.AllArgsConstructor;
import pl.lotto.drawdategenerator.DrawDateGeneratorFacade;
import pl.lotto.drawdategenerator.dto.DrawDateDto;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class NumbersGeneratorFacade {

    private final WinningNumberGenerator winningNumberGenerator;
    private final WinningNumberRepository winningNumberRepository;

    private final DrawDateGeneratorFacade drawDateGeneratorFacade;


    //dopisać testy
    public WinningNumbersDto generateWinningNumbers() {
        List<Integer> winningNumbers = winningNumberGenerator.generateWinningNumberList();
        DrawDateDto drawDateDto = drawDateGeneratorFacade.generateNextDrawDate(LocalDateTime.now());
        LocalDateTime drawDate = drawDateDto.drawDate();
        winningNumberRepository.save(WinningNumbers.builder()
                .date(drawDate)
                .winningNumbers(winningNumbers)
                .build());
        return new WinningNumbersDto(winningNumbers);
    }

    public WinningNumbersDto retriveWinningNumbersforDate(LocalDateTime date) {
        Optional<WinningNumbers> winningNumbers = winningNumberRepository.findByDate(date);

        WinningNumbers winningNumbers1 = winningNumbers.orElse(WinningNumbers.builder()
                .winningNumbers(Collections.emptyList())
                .build());


        return new WinningNumbersDto(winningNumbers.get().getWinningNumbers());
    }

}
