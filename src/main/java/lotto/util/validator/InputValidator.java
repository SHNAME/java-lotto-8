package lotto.util.validator;

public final class InputValidator {
    private static final String PURCHASE_PRICE = "^[1-9][0-9]*$";
    private static final String WINNING_NUMBERS = "^\\d+(,\\d+){5}$";

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

    private static void validateWinningNumberFormat(String userInput) {
        if (!userInput.matches(WINNING_NUMBERS)) {
            throw new IllegalArgumentException("당첨 번호를 잘못 입력하셨습니다.");
        }
    }


}
