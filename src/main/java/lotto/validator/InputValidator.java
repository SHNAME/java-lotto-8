package lotto.validator;

public final class InputValidator {
    private static final String PURCHASE_PRICE = "^[1-9][0-9]*$";

    public static void validatePurchasePrice(String userInput) {
        validatePriceFormat(userInput);
        validateAmountUnit(userInput);
    }

    private static void validatePriceFormat(String userInput) {
        if (!userInput.matches(PURCHASE_PRICE)) {
            throw new IllegalArgumentException("구매 가격을 잘못 입력하셨습니다.");
        }
    }

    private static void validateAmountUnit(String userInput) {
        if ((Integer.parseInt(userInput) % 1000) != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요");
        }
    }


}
