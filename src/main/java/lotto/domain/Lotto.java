package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBERS_DUPLICATION.getMessage());
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_OF_LOTTO_NUMBERS.getMessage());
        }
    }

    @Override
    public String toString() {
        numbers.sort(Integer::compareTo);
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
