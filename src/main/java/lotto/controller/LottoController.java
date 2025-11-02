package lotto.controller;

import java.util.List;
import lotto.constant.GuideMessage;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.util.parser.Parser;
import lotto.util.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startLottoController() {
        Lottos lottos = purchaseLottos();
        LottoMachine lottoMachine = makeLottoMachine();
        announceLottoResult(lottos, lottoMachine);
    }

    private void announceLottoResult(Lottos lottos, LottoMachine lottoMachine) {
        lottos.checkLottoResult(lottoMachine);
        OutputView.printWinningStatistics(lottos.calculateStatics(), lottos.calculateRateOfReturn());
    }

    private Lottos purchaseLottos(){
        Integer purchaseAmount = inputPurchaseAmount();
        Lottos purchasedLotto = new Lottos(purchaseAmount / 1000);
        OutputView.printPurchaseLottoNumbers(purchasedLotto.getLottos());
        return purchasedLotto;
    }

    private LottoMachine makeLottoMachine(){
        LottoMachine lottoMachine;
        while(true){
            try{
                List<Integer> winningNumber = inputWinningNumber();
                Integer bonusNumber = inputBonusNumber();
                lottoMachine = new LottoMachine(winningNumber,bonusNumber);
                break;
            }catch (IllegalArgumentException e){
                outputView.printGuideMessage(e.getMessage());
            }
        }
        return lottoMachine;
    }

    private Integer inputPurchaseAmount() {
        outputView.printGuideMessage(GuideMessage.PURCHASE_AMOUNT.getMessage());
        String purchaseAmount;
        while (true) {
            try {
                purchaseAmount = inputView.readInput();
                InputValidator.validatePurchasePrice(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printGuideMessage(e.getMessage());
            }
        }
        System.out.println();
        return Integer.parseInt(purchaseAmount);
    }

    private List<Integer> inputWinningNumber() {
        outputView.printGuideMessage(GuideMessage.WINNING_NUMBER.getMessage());
        String winningNumber;
        while (true) {
            try {
                winningNumber = inputView.readInput();
                InputValidator.validateWinningNumbers(winningNumber);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printGuideMessage(e.getMessage());
            }
        }
        System.out.println();
        return Parser.parseStringToList(winningNumber);
    }

    private Integer inputBonusNumber() {
        outputView.printGuideMessage(GuideMessage.BONUS_NUMBER.getMessage());
        String bonusNumber;
        while (true) {
            try {
                bonusNumber = inputView.readInput();
                InputValidator.validateBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printGuideMessage(e.getMessage());
            }
        }
        System.out.println();
        return Integer.parseInt(bonusNumber);
    }


}
