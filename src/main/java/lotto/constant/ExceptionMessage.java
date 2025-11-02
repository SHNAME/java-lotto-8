package lotto.constant;

public enum ExceptionMessage {
    WINNING_NUMBERS_DUPLICATION("당첨 번호는 중복 입력이 불가능합니다."),
    INVALID_NUMBER_OF_LOTTO_NUMBERS("로또 번호는 반드시 6개를 입력해야 합니다."),
    BETWEEN_WINNING_NUMBERS_AND_BONUS_NUMBER("당첨 번호와 보너스 번호는 서로 중복될 수 없습니다"),
    PRICE_FORMAT_INVALID("구매 금액 형식이 올바르지 않습니다. 숫자만 입력해주세요."),
    PURCHASE_UNIT_INVALID("구매 금액은 1000원 단위로 입력해야 합니다."),
    WINNING_NUMBERS_FORMAT_INVALID("당첨 번호 입력 형식이 올바르지 않습니다. 숫자를 쉼표(,)로 구분해주세요. 예: 1,2,3,4,5,6"),
    WINNING_NUMBERS_RANGE_INVALID("당첨 번호는 1부터 45 사이의 값만 가능합니다."),
    BONUS_NUMBER_FORMAT_INVALID("보너스 번호 형식이 올바르지 않습니다. 숫자만 입력해주세요."),
    BONUS_NUMBER_RANGE_INVALID("보너스 번호는 1부터 45 가이의 값만 가능합니다.");


    private final String message;

    ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
