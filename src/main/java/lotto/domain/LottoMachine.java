package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.constant.Rank;

public class LottoMachine {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public LottoMachine(List<Integer> winningNumbers, Integer bonusNumber) {
        validateNoDuplicateWithBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateNoDuplicateWithBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.stream().anyMatch(lottoNumber -> lottoNumber.equals(bonusNumber))) {
            throw new IllegalArgumentException(ExceptionMessage.BETWEEN_WINNING_NUMBERS_AND_BONUS_NUMBER.getMessage());
        }
    }

    public Rank checkRank(List<Integer> lottoNumber) {
        List<Integer> intersectionNumbers = new ArrayList<>(lottoNumber);
        intersectionNumbers.retainAll(winningNumbers);
        return Rank.calculateRank(intersectionNumbers.size(),lottoNumber.contains(bonusNumber));
    }


}
