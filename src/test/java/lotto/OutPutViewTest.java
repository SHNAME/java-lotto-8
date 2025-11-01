package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lotto.constant.Rank;
import org.junit.jupiter.api.Test;

public class OutPutViewTest {

    @Test
    public void 구매한_로또_번호들을_출력하는_테스트() {
        List<Integer> lotto1 = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(lotto1);
    }

    @Test
    public void 당첨_통계를_출력하는_테스트(){
        List<Rank> result = List.of(Rank.LOSING,Rank.FIRST_PRIZE,Rank.SECOND_PRIZE);
        List<String> list = Arrays.stream(Rank.values())
                .sorted(Comparator.comparingLong(r -> r.getWinningAmount()))
                .filter(rank -> !rank.equals(Rank.LOSING))
                .map(rank ->
                        rank.getResultString()+" - " + Collections.frequency(result,rank) + "개"
                ).toList();
    }
}
