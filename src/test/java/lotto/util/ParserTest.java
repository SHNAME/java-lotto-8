package lotto.util;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    void 당첨_번호_파싱을_파싱하여_list로_반환한다() {
        String input = "1,2,3,4,5,6";
        List<Integer> list = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(2, list.get(1));
        Assertions.assertEquals(3, list.get(2));
        Assertions.assertEquals(4, list.get(3));
    }

}
