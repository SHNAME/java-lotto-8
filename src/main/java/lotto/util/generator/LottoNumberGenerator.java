package lotto.util.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public final class LottoNumberGenerator {

    public static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }


}
