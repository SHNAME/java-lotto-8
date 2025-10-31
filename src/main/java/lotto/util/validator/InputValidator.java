package lotto.util.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.Parser;

public final class InputValidator {
    private static final String PURCHASE_PRICE = "^[1-9][0-9]*$";
    private static final String WINNING_NUMBERS = "^\\d+(,\\d+){5}$";
    private static final String BONUS_NUMBER = "\\d+";

    public static void validatePurchasePrice(String userInput) {
        validatePriceFormat(userInput);
        validateAmountUnit(userInput);
    }

    public static void validateWinningNumbers(String userInput) {
        validateWinningNumberFormat(userInput);
        validateWinningNumberRange(Parser.parseStringToList(userInput));
        validateWinningNumberUnique(Parser.parseStringToList(userInput));
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

    private static void validateWinningNumberRange(List<Integer> winningNumbers) {
        if (winningNumbers.stream().anyMatch(num -> (num < 1) || (num > 45))) {
            throw new IllegalArgumentException("당첨 번호 숫자는 1부터 45까지만 입력해 주세요.");
        }

    }

    private static void validateWinningNumberUnique(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("당첨 번호 숫자는 중복될 수 없습니다.");
        }
    }

    private static void validateBonusNumberFormat(String userInput) {
        if (!userInput.matches(BONUS_NUMBER)) {
            throw new IllegalArgumentException("보너스 번호를 잘못 입력하셨습니다.");
        }
    }


}
