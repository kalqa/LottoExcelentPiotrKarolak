package pl.lotto.numbersgenerator;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;


@Document
@Builder
@Data
public class WinningNumbers {

    @Id
    private String id;

    private List<Integer> winningNumbers;

    private LocalDateTime date;
}
