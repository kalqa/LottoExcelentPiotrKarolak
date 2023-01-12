package pl.lotto.drawdategenerator.dto;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record DrawDateDto(LocalDateTime drawDate) {
}
