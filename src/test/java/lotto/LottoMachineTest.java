package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
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
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> new LottoMachine(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
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

    @Test
    void 구매한_로또_번호와_당첨_번호가_5등인_경우() {
        List<Integer> lottoNumbers = List.of(1, 3, 5, 14, 22, 45);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> intersectionNumbers = new ArrayList<>(lottoNumbers);
        intersectionNumbers.retainAll(winningNumbers);
        assertThat(intersectionNumbers.size()).isEqualTo(3);
    }

    @Test
    void 구매한_로또_번호와_당첨_번호가_꽝인_경우()  {
        List<Integer> lottoNumbers = List.of(13, 14, 16, 38, 42, 45);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> intersectionNumbers = new ArrayList<>(lottoNumbers);
        intersectionNumbers.retainAll(winningNumbers);
        assertThat(intersectionNumbers.size()).isEqualTo(0);
    }

    @DisplayName("5개가 일치하는 경우 보너스 번호도 비교한다.")
    @Test
    void 구매한_로또_번호와_당첨_번호가_2등_경우()  {
        List<Integer> lottoNumbers = List.of(1, 1, 3, 4, 5, 45);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 45;
        List<Integer> intersectionNumbers = new ArrayList<>(lottoNumbers);
        intersectionNumbers.retainAll(winningNumbers);
        boolean result = lottoNumbers.contains(bonusNumber);
        assertThat(intersectionNumbers.size()).isEqualTo(5);
        Assertions.assertTrue(result);
    }


}
