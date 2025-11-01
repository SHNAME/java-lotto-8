package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OutPutViewTest {

    @Test
    public void 구매한_로또_번호들을_출력하는_테스트() {
        List<Integer> lotto1 = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(lotto1);
    }
}
