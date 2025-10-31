package lotto;

import java.util.List;
import lotto.domain.LottoMachine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @DisplayName("로또 번호와 보너스 번호가 중복된 경우")
    @Test
    void 로또_당첨_번호_관리_기능_테스트_중복() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 33);
        Integer bonusNumber = 33;
        LottoMachine lottoMachine = new LottoMachine(winningNumber, bonusNumber);
        boolean result = winningNumber.stream().anyMatch(num -> num.equals(bonusNumber));
        Assertions.assertTrue(result);
    }
    @DisplayName("로또 번호와 보너스 번호 사이에 중복이 없는 경우")
    @Test
    void 로또_당첨_번호_관리_기능_테스트() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 33);
        Integer bonusNumber = 44;
        LottoMachine lottoMachine = new LottoMachine(winningNumber, bonusNumber);
        boolean result = winningNumber.stream().anyMatch(num -> num.equals(bonusNumber));
        Assertions.assertFalse(result);
    }


}
