package pl.lotto.numberreceiver;

enum ValidationError {


    NOT_SIX_NUMBERS("not six numbers"),
    DUPLICATED_NUMBERS("user gave duplicate"),
    OUT_OF_RANGE("number gave number out of range");

    final String message;

    ValidationError(String message) {
        this.message = message;
    }
}
