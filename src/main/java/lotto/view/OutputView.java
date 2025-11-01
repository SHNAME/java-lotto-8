package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public final class OutputView {

    public static void printPurchaseLottoNumbers(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

}
