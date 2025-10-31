package lotto.domain;

import java.util.List;

public class LottoMachine {
    private final List<Integer> winningNumbers;
    private final Integer BonusNumber;

    public LottoMachine(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.BonusNumber = bonusNumber;
    }
}
