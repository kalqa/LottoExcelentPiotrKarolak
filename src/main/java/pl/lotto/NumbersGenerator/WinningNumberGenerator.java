package pl.lotto.NumbersGenerator;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class WinningNumberGenerator {


    public final int WINNING_LIST_SIZE = 6;
    public final int MIN_NUMBER = 1;
    public final int MAX_NUMBER = 99;


    public List<Integer> generateWinningNumberList() {
        List<Integer> winningList = new Random().
                ints(WINNING_LIST_SIZE, MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        return winningList;
    }
}
