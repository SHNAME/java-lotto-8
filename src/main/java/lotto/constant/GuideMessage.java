package lotto.constant;

public enum GuideMessage {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요"),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    INPUT_AGAIN("다시 입력해 주세요");

    private final String message;

    GuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
