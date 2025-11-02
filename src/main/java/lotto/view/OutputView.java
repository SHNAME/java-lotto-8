package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.constant.GuideMessage;
import lotto.domain.Lotto;

public final class OutputView {

    public void printPurchaseLottoNumbers(List<Lotto> lottos) {
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void printWinningStatistics(List<String> ranks, double rateOfReturn) {
        System.out.println("당첨 통계\n");
        for (String rank : ranks) {
            System.out.println(rank);
        }
        DecimalFormat df = new DecimalFormat("#,###.#");
        System.out.println("총 수익률은 " + df.format(rateOfReturn) + "%입니다.");
    }

    public void printGuideMessage(String message){
        System.out.println(message);
    }

    public void printExceptionMessage(String message){
        System.out.println(ExceptionMessage.ERROR.getMessage() +" " +message);
        System.out.println(GuideMessage.INPUT_AGAIN);
    }


}
