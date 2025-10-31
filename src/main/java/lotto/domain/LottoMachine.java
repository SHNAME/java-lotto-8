package lotto.domain;

import java.util.List;

public class LottoMachine {
    private final List<Integer> winningNumbers;
    private final Integer BonusNumber;

    public LottoMachine(List<Integer> winningNumbers, Integer bonusNumber) {
        validateNoDuplicateWithBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.BonusNumber = bonusNumber;
    }

    private void validateNoDuplicateWithBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        if(winningNumbers.stream().anyMatch(lottoNumber -> lottoNumber.equals(bonusNumber))){
            throw new IllegalArgumentException("당첨 번호와 보너스 번호 사이에 중복은 없어야 합니다.");
        }
    }
}
