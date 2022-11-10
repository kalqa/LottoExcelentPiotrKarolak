package pl.lotto.numberreceiver;

public class NumberReceiverConfiguration {

    public NumberReceiverFacade numberReceiverFacadeForTest() {
        NumberReceiverValidator numberReceiverValidator = new NumberReceiverValidator();
        return new NumberReceiverFacade(numberReceiverValidator);
    }
}
