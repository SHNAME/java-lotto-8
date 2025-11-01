package lotto.constant;

import java.util.Arrays;

public enum Rank {
    FIRST_PRIZE(6, 2_000_000_000, false),
    SECOND_PRIZE(5, 30_000_000, true),
    THIRD_PRIZE(5, 1_500_000, false),
    FOURTH_PRIZE(4, 50_000, false),
    FIFTH_PRIZE(3, 5_000, false),
    LOSING(0, 0, false);

    private final int matchCount;
    private final long winningAmount;
    private final boolean hasBonus;

    Rank(int matchCount, long winningAmount, boolean hasBonus) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.hasBonus = hasBonus;
    }

    public static Rank calculateRank(int matchCount, boolean bonusMatchResult) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount && rank.hasBonus == bonusMatchResult)
                .findFirst().
                orElseGet(() -> Arrays.stream(Rank.values())
                        .filter(rank -> rank.matchCount == matchCount && rank.hasBonus == false)
                        .findFirst().orElse(Rank.LOSING));
    }
}
