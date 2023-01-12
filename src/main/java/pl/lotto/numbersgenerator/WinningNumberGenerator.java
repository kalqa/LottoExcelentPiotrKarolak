package pl.lotto.numbersgenerator;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class WinningNumberGenerator {

    public static final int WINNING_LIST_SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 99;

    public List<Integer> generateWinningNumberList() {
        return new Random()
                .ints(WINNING_LIST_SIZE, MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
}
