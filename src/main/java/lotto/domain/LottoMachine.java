package lotto.domain;

import java.util.ArrayList;
import java.util.List;
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
            throw new IllegalArgumentException("당첨 번호와 보너스 번호 사이에 중복은 없어야 합니다.");
        }
    }

    public Rank checkRank(List<Integer> lottoNumber) {
        List<Integer> intersectionNumbers = new ArrayList<>(lottoNumber);
        intersectionNumbers.retainAll(winningNumbers);
        return calculateRank(intersectionNumbers.size(), lottoNumber);
    }

    private Rank calculateRank(int matchCount, List<Integer> lottoNumbers) {
        if (matchCount == 6) {
            return Rank.FIRST_PRIZE;
        }
        if (matchCount == 5 && lottoNumbers.contains(bonusNumber)) {
            return Rank.SECOND_PRIZE;
        }
        if (matchCount == 5) {
            return Rank.THIRD_PRIZE;
        }
        if (matchCount == 4) {
            return Rank.FOURTH_PRIZE;
        }
        if (matchCount == 3) {
            return Rank.THIRD_PRIZE;
        }
        return Rank.LOSING;
    }
}
