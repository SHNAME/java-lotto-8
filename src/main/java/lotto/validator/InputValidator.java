package lotto.validator;

public final class InputValidator {
    private static final String PURCHASE_PRICE = "^[1-9][0-9]*$";

    private static void validatePriceFormat(String userInput) {
        if(!userInput.matches(PURCHASE_PRICE)){
            throw  new IllegalArgumentException("구매 가격을 잘못 입력하셨습니다.");
        }
    }


}
