package lotto;

import java.util.List;
import lotto.constant.Rank;
import lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottosTest {
    @Test
    void 사용자가_구매한_로또_개수만큼_로또를_생성한다() {
        Integer count = 5;
        Lottos lottos = new Lottos(5);
        Assertions.assertThat(lottos.getLottoCount()).isEqualTo(count);
    }

    @Test
    void 구매한_로또의_수익률을_계산한다() {
        List<Rank> result = List.of(Rank.FIFTH_PRIZE, Rank.LOSING, Rank.FIRST_PRIZE, Rank.LOSING);
        long sum = 0L;
        for (Rank rank : result) {
            sum+=rank
        }
    }
}
