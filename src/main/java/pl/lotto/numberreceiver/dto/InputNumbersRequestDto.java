package pl.lotto.numberreceiver.dto;

import java.util.List;

public record InputNumbersRequestDto(List<Integer> numbersFromUser) {
}
