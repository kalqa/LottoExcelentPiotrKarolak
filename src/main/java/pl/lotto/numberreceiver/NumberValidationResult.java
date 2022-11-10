package pl.lotto.numberreceiver;

record NumberValidationResult(String validationMessage) {


    public static final String SUCCESS_MESSAGE = "success";

    public static NumberValidationResult success(){
        return new NumberValidationResult(SUCCESS_MESSAGE);
    }
    public static NumberValidationResult failure(String message){
        return new NumberValidationResult(message);
    }

}
