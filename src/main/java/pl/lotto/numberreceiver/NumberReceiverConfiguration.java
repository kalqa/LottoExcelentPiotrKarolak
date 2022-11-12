package pl.lotto.numberreceiver;

public class NumberReceiverConfiguration {

    public NumberReceiverFacade numberReceiverFacadeForTest() {
        NumberReceiverValidator numberReceiverValidator = new NumberReceiverValidator();
        LotteryDateGenerator lotteryDateGenerator = new LotteryDateGenerator();
        UserLotteryIdGenerator userLotteryIdGenerator = new UserLotteryIdGenerator();
        return new NumberReceiverFacade(numberReceiverValidator,userLotteryIdGenerator,lotteryDateGenerator);
    }
}
