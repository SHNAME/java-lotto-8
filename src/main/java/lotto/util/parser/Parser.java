package lotto.util;

import java.util.Arrays;
import java.util.List;

public final class Parser {
    public static  List<Integer> parseStringToList(String userInput) {
        return Arrays.stream(userInput.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
