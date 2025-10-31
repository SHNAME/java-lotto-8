package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.generator.LottoNumberGenerator;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.createLottoNumbers()));
        }
    }

    public int getLottoCount() {
        return lottos.size();
    }
}
