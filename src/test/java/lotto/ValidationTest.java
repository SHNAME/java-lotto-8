package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationTest {


    @Test
    void 로또_가격에_숫자가_아닌_문자를_입력한_경우(){
        String input1 = "-122";
        String input2 = "0191";
        String regex = "^[1-9][0-9]*$";
        Assertions.assertFalse(input1.matches(regex));
        Assertions.assertFalse(input2.matches(regex));
    }

    @Test
    void 로또_가격을_정상적으로_입력한_경우(){
        String input1 = "1222";
        String input2 = "11";
        String regex = "^[1-9][0-9]*$";
        Assertions.assertTrue(input1.matches(regex));
        Assertions.assertTrue(input2.matches(regex));
    }

}
