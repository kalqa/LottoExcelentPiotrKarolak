package pl.lotto.resultannoucer;


enum WinningMessage {

    WIN("Congrats, you have won!"),
    LOSE("You have lost");

    final String message;

    WinningMessage(String message) {
        this.message = message;
    }
}
