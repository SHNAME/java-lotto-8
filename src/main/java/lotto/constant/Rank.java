package lotto.constant;

import java.util.Arrays;

public enum Rank {
    FIRST_PRIZE(6, 2_000_000_000, false, "6개 일치 (2,000,000,000원)"),
    SECOND_PRIZE(5, 30_000_000, true, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_PRIZE(5, 1_500_000, false, "5개 일치 (1,500,000원)"),
    FOURTH_PRIZE(4, 50_000, false, "4개 일치 (50,000원)"),
    FIFTH_PRIZE(3, 5_000, false, "3개 일치 (5,000원)"),
    LOSING(0, 0, false, "");

    private final int matchCount;
    private final long winningAmount;
    private final boolean hasBonus;
    private final String resultString

    Rank(int matchCount, long winningAmount, boolean hasBonus, String resultString) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.hasBonus = hasBonus;
        this.resultString = resultString;
    }

    public static Rank calculateRank(int matchCount, boolean bonusMatchResult) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount && rank.hasBonus == bonusMatchResult)
                .findFirst().
                orElseGet(() -> Arrays.stream(Rank.values())
                        .filter(rank -> rank.matchCount == matchCount && rank.hasBonus == false)
                        .findFirst().orElse(Rank.LOSING));
    }

    public static long getWinningAmount(Rank rank) {
        return rank.winningAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }


}
