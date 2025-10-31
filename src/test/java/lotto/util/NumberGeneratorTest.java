package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {

    @Test
    void 중복되지_않은_숫자를_생성하는_테스트() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        Assertions.assertThat(numbers.size()).isEqualTo(6);
        Assertions.assertThat(uniqueNumbers.size()).isEqualTo(numbers.size());
    }
}