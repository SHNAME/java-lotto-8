package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.Rank;
import lotto.util.generator.LottoNumberGenerator;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();
    private final List<Rank> result = new ArrayList<>();

    public Lottos(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.createLottoNumbers()));
        }
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public void checkLottoResult(LottoMachine lottoMachine) {
        for (Lotto lotto : lottos) {
            result.add(lottoMachine.checkRank(lotto.getNumbers()));
        }
    }

    public double calculateRateOfReturn() {
        long sum = 0L;
        for (Rank rank : result) {
            sum += Rank.getWinningAmount(rank);
        }
        return Math.round((((double) sum / (lottos.size() * 1000)) * 100) * 10) / 10.0;
    }


    public List<Lotto> getLottos() {
        return lottos;
    }
    public List<Rank> getResult(){
        return  result;
    }
}
