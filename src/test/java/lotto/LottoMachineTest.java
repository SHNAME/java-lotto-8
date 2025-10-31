package lotto;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @Test
    void 로또_당첨_번호_관리_기능_테스트() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 33;
        LottoMachine lottoMachine = new LottoMachine(winningNumber,bonusNumber);
    }
}
