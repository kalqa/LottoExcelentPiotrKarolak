package pl.lotto.numberreceiver;

enum ValidationError {


    NOT_SIX_NUMBERS("not six numbers"),
    DUPLICATED_NUMBERS("hasUserGaveDuplicate"),
    OUT_OF_RANGE("hasUserGaveNumberInRange");

    final String message;

    ValidationError(String message) {
        this.message = message;
    }
}
